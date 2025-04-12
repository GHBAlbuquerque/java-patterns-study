package com.patterns.communication.gateway;

import com.patterns.common.dto.message.CustomQueueMessage;
import com.patterns.common.dto.request.PaymentEventDTO;
import com.patterns.common.interfaces.gateways.PaymentEventGateway;
import com.patterns.domain.strategy.EventStrategy;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static io.awspring.cloud.sqs.annotation.SqsListenerAcknowledgementMode.ON_SUCCESS;

public class PaymentEventGatewayImpl implements PaymentEventGateway {

    private final Logger log = LogManager.getLogger(PaymentEventGatewayImpl.class);

    private final List<EventStrategy> eventUseCases;

    public PaymentEventGatewayImpl(List<EventStrategy> eventStrategyList) {
        this.eventUseCases = eventStrategyList;
    }

    @Override
    @SqsListener(queueNames = "${aws.queue.payment_update.endpoint}", maxConcurrentMessages = "1", maxMessagesPerPoll = "1", acknowledgementMode = ON_SUCCESS)
    public void listenToPaymentUpdateEvent(CustomQueueMessage<PaymentEventDTO> message) {
        log.info("Received message: {}", message);

        try {
            final var paymentStatus = message.body().paymentStatus();
            final var invoiceId = message.headers().invoiceId();

            this.eventUseCases
                    .stream()
                    .filter(eventUseCase -> eventUseCase.getEventStatus().equals(paymentStatus))
                    .findFirst()
                    .ifPresentOrElse(
                            eventUseCase -> eventUseCase.updateInvoice(invoiceId),
                            () -> log.warn("No use case found for event status: {}", paymentStatus)
                    );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
