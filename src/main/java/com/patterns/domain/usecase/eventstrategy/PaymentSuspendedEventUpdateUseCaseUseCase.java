package com.patterns.domain.usecase.eventstrategy;

import com.patterns.common.interfaces.external.MessageSender;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.patterns.domain.enums.PaymentEventsEnum.PAYMENT_SUSPENDED;
import static com.patterns.domain.enums.StatusEnum.SUSPENDED;

public class PaymentSuspendedEventUpdateUseCaseUseCase extends EventUseCaseAbstract {

    private final Logger log = LogManager.getLogger(PaymentSuspendedEventUpdateUseCaseUseCase.class);

    public PaymentSuspendedEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway, MessageSender messageSender) {
        super(invoiceGateway, messageSender);
    }

    @Override
    public String getEventStatus() {
        return PAYMENT_SUSPENDED;
    }

    @Override
    public String getInvoiceUpdateStatus() {
        return SUSPENDED;
    }

    @Override
    public void updateInvoice(String invoiceId) {
        log.info("Event received with status: {} and invoice id {}", getEventStatus(), invoiceId);

        try {
            final var invoice = invoiceGateway.getInvoiceById(invoiceId);

            log.info("Updating invoice status to: {}", getInvoiceUpdateStatus());

            invoice.setStatus(getInvoiceUpdateStatus());
            invoiceGateway.saveInvoice(invoice);

        } catch (Exception e) {
            log.error("Error updating invoice: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
