package com.patterns.domain.strategy;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.patterns.domain.enums.PaymentEventsEnum.PAYMENT_INCONSISTENT;
import static com.patterns.domain.enums.StatusEnum.INCONSISTENT;

public class PaymentInconsistentEventStrategyImpl implements EventStrategy {

    private final Logger log = LogManager.getLogger(PaymentInconsistentEventStrategyImpl.class);
    private final InvoiceGateway invoiceGateway;

    public PaymentInconsistentEventStrategyImpl(InvoiceGateway invoiceGateway) {
        this.invoiceGateway = invoiceGateway;
    }

    @Override
    public String getEventStatus() {
        return PAYMENT_INCONSISTENT;
    }

    @Override
    public String getInvoiceUpdateStatus() {
        return INCONSISTENT;
    }

    @Override
    public void updateInvoice(String invoiceId) {
        log.info("Event received with status: {} and invoice id {}", getEventStatus(), invoiceId);

        try {
            final var optional = invoiceGateway.getInvoiceById(invoiceId);
            if (optional.isEmpty()) return;

            log.info("Updating invoice status to: {}", getInvoiceUpdateStatus());

            final var invoice = optional.get();
            invoice.setStatus(getInvoiceUpdateStatus());
            invoiceGateway.saveInvoice(invoice);

        } catch (Exception e) {
            log.error("Error updating invoice: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
