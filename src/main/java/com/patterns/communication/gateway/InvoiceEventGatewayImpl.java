package com.patterns.communication.gateway;

import com.patterns.common.dto.message.CustomMessageHeaders;
import com.patterns.common.dto.message.CustomQueueMessage;
import com.patterns.common.interfaces.external.MessageSender;
import com.patterns.common.interfaces.gateways.InvoiceEventGateway;
import com.patterns.domain.entity.Invoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class InvoiceEventGatewayImpl implements InvoiceEventGateway {

    private final Logger log = LogManager.getLogger(InvoiceEventGatewayImpl.class);

    protected final MessageSender messageSender;

    @Value("${aws.queue.invoice_update.endpoint}")
    protected String queueUrl;

    public InvoiceEventGatewayImpl(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void sendUpdateEvent(Invoice invoice, String eventStatus) {
        log.info("Sending event with status: {} and invoice id {}", eventStatus, invoice.getId());

        try {
            final var message = new CustomQueueMessage<Invoice>(
                    new CustomMessageHeaders(
                            invoice.getId(),
                            UUID.randomUUID().toString()),
                    invoice);

            messageSender.sendMessage(message, queueUrl);

            log.info("Message sent.");

        } catch (Exception e) {
            log.error("Error sending event: {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
