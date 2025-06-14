package com.patterns.communication.gateway;

import com.patterns.common.dto.message.CustomQueueMessage;
import com.patterns.common.dto.request.PaymentEventDTO;
import com.patterns.common.exception.ExceptionCodesEnum;
import com.patterns.common.exception.custom.InvalidMessageException;
import com.patterns.common.interfaces.gateways.PaymentEventGateway;
import com.patterns.common.interfaces.strategy.EventStrategy;
import com.patterns.common.interfaces.usecases.BatchValidateInvoiceUseCase;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static io.awspring.cloud.sqs.annotation.SqsListenerAcknowledgementMode.ON_SUCCESS;

public class PaymentEventGatewayImpl implements PaymentEventGateway {

    private final Logger log = LogManager.getLogger(PaymentEventGatewayImpl.class);

    private final List<EventStrategy> eventUseCases;

    private final BatchValidateInvoiceUseCase batchValidateInvoiceUseCase;

    public PaymentEventGatewayImpl(List<EventStrategy> eventUseCases, BatchValidateInvoiceUseCase batchValidateInvoiceUseCase) {
        this.eventUseCases = eventUseCases;
        this.batchValidateInvoiceUseCase = batchValidateInvoiceUseCase;
    }

    @Override
    @SqsListener(queueNames = "${aws.queue.payment_update.endpoint}", maxConcurrentMessages = "1", maxMessagesPerPoll = "1", acknowledgementMode = ON_SUCCESS)
    public void listenToPaymentUpdateEvents(List<CustomQueueMessage<PaymentEventDTO>> messages) {
        log.info("Received messages: {}", messages);

        //TODO? ver pq nao consegue ler
        final var validMessages = filterPaymentUpdateEventsByInvoicesCheck(messages);

        validMessages.forEach(this::processPaymentUpdateEvent);
    }

    @Override
    public void processPaymentUpdateEvent(CustomQueueMessage<PaymentEventDTO> message) {
        log.info("Processing message: {}", message);

        try {
            final var paymentStatus = message.body().paymentStatus();
            final var invoiceId = message.headers().invoiceId();

            final var strategy = this.eventUseCases
                    .stream()
                    .filter(eventUseCase -> eventUseCase.getEventStatus().equals(paymentStatus))
                    .findFirst()
                    .orElseThrow(
                            () -> new InvalidMessageException(
                                    ExceptionCodesEnum.INVOICE_04_INVALID_PAYMENT_EVENT.name(),
                                    String.format("No use case found for event status: %s", paymentStatus))
                    );

            strategy.updatePaymentStatusOnInvoice(invoiceId);

            log.info("Invoice updated successfully with status: {}", strategy.getInvoiceUpdateStatus());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CustomQueueMessage<PaymentEventDTO>> filterPaymentUpdateEventsByInvoicesCheck(List<CustomQueueMessage<PaymentEventDTO>> messages) {
        final List<String> invoicesIds = messages.stream()
                .map(message -> message.headers().invoiceId())
                .toList();

        final Map<String, Boolean> validations = batchValidateInvoiceUseCase.validateAllAsync(invoicesIds).join();
        final List<String> validInvoices = validations.entrySet().stream()
                .filter(entry -> Boolean.TRUE.equals(entry.getValue()))
                .map(entry -> entry.getKey())
                .toList();

        return messages.stream()
                .filter(message -> validInvoices.contains(message.headers().invoiceId()))
                .toList();
    }

}
