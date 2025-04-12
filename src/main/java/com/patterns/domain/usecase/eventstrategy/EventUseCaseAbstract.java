package com.patterns.domain.usecase.eventstrategy;

import com.patterns.common.dto.message.CustomMessageHeaders;
import com.patterns.common.dto.message.CustomQueueMessage;
import com.patterns.common.exception.custom.UpdateEntityException;
import com.patterns.common.interfaces.external.MessageSender;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.domain.entity.Invoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public abstract class EventUseCaseAbstract {

    private final Logger log = LogManager.getLogger(EventUseCaseAbstract.class);

    protected final InvoiceGateway invoiceGateway;

    protected final MessageSender messageSender;

    @Value("${aws.queue.invoice_update.endpoint}")
    protected String queueUrl;

    protected EventUseCaseAbstract(InvoiceGateway invoiceGateway, MessageSender messageSender) {
        this.invoiceGateway = invoiceGateway;
        this.messageSender = messageSender;
    }

    public abstract String getEventStatus();

    public abstract String getInvoiceUpdateStatus();

    public abstract void updateInvoice(final String invoiceId) throws UpdateEntityException;

    public void sendUpdateEvent(final Invoice invoice, final String eventStatus) {
        log.info("Sending event with status: {} and invoice id {}", eventStatus, invoice.getId());

        try {
            final var messageId = UUID.randomUUID().toString();
            final var message = new CustomQueueMessage<Invoice>(
                    new CustomMessageHeaders(
                            messageId,
                            invoice.getId(),
                            UUID.randomUUID().toString()
                    ),
                    invoice);


            messageSender.sendMessage(message, messageId, queueUrl);

            log.info("Event sent with messageId: {}", messageId);

        } catch (Exception e) {
            log.error("Error sending event: {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
