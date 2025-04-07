package com.patterns.domain.usecase.eventstrategy;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.patterns.domain.enums.EventsEnum.PAYMENT_CANCELLED;
import static com.patterns.domain.enums.StatusEnum.INACTIVE;

public class PaymentCreatedEventUpdateUseCaseUseCase extends EventUseCaseAbstract {

    private final Logger log = LogManager.getLogger(PaymentCreatedEventUpdateUseCaseUseCase.class);

    public PaymentCreatedEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway) {
        super(invoiceGateway);
    }

    @Override
    public String getEventStatus() {
        return PAYMENT_CANCELLED;
    }

    @Override
    public String getInvoiceUpdateStatus() {
        return INACTIVE;
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
