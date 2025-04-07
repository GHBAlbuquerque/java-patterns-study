package com.patterns.communication.gateway;

import com.patterns.common.dto.message.CustomQueueMessage;
import com.patterns.common.dto.request.PaymentEventDTO;
import com.patterns.common.interfaces.gateways.MessagingGateway;
import com.patterns.domain.usecase.eventstrategy.EventUseCaseAbstract;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MessagingGatewayImpl implements MessagingGateway {

    private final Logger log = LogManager.getLogger(MessagingGatewayImpl.class);

    private final List<EventUseCaseAbstract> eventUseCases;

    public MessagingGatewayImpl(List<EventUseCaseAbstract> eventUseCases) {
        this.eventUseCases = eventUseCases;
    }

    @Override
    public void listenToInvoiceUpdate(CustomQueueMessage<PaymentEventDTO> message) {
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
