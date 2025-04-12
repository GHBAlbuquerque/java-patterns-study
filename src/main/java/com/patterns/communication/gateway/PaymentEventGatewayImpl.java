package com.patterns.communication.gateway;

import com.patterns.common.dto.message.CustomQueueMessage;
import com.patterns.common.dto.request.PaymentEventDTO;
import com.patterns.common.exception.ExceptionCodesEnum;
import com.patterns.common.exception.custom.InvalidMessageException;
import com.patterns.common.interfaces.gateways.PaymentEventGateway;
import com.patterns.domain.usecase.eventstrategy.EventUseCaseAbstract;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static io.awspring.cloud.sqs.annotation.SqsListenerAcknowledgementMode.ON_SUCCESS;

public class PaymentEventGatewayImpl implements PaymentEventGateway {

    private final Logger log = LogManager.getLogger(PaymentEventGatewayImpl.class);

    private final List<EventUseCaseAbstract> eventUseCases;

    public PaymentEventGatewayImpl(List<EventUseCaseAbstract> eventUseCases) {
        this.eventUseCases = eventUseCases;
    }

    @Override
    @SqsListener(queueNames = "${aws.queue.payment_update.endpoint}", maxConcurrentMessages = "1", maxMessagesPerPoll = "1", acknowledgementMode = ON_SUCCESS)
    public void listenToPaymentUpdateEvent(CustomQueueMessage<PaymentEventDTO> message) {
        log.info("Received message: {}", message);

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

            strategy.updateInvoice(invoiceId);

            log.info("Invoice updated successfully with status: {}", strategy.getInvoiceUpdateStatus());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
