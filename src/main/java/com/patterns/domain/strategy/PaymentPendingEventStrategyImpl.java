package com.patterns.domain.strategy;

import com.patterns.common.exception.ExceptionCodesEnum;
import com.patterns.common.exception.custom.UpdateEntityException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.patterns.domain.enums.PaymentEventsEnum.PAYMENT_PENDING;
import static com.patterns.domain.enums.StatusEnum.PENDING;

public class PaymentPendingEventStrategyImpl implements EventStrategy {

    private final Logger log = LogManager.getLogger(PaymentPendingEventStrategyImpl.class);
    private final InvoiceGateway invoiceGateway;

    public PaymentPendingEventStrategyImpl(InvoiceGateway invoiceGateway) {
        this.invoiceGateway = invoiceGateway;
    }

    @Override
    public String getEventStatus() {
        return PAYMENT_PENDING;
    }

    @Override
    public String getInvoiceUpdateStatus() {
        return PENDING;
    }

    @Override
    public void updateInvoice(String invoiceId) throws UpdateEntityException {
        try {
            log.info("Event received with status: {} and invoice id {}", getEventStatus(), invoiceId);

            final var optional = invoiceGateway.getInvoiceById(invoiceId);

            log.info("Updating invoice status to: {}", getInvoiceUpdateStatus());

            final var invoice = optional.orElseThrow();
            invoice.setStatus(getInvoiceUpdateStatus());
            invoiceGateway.saveInvoice(invoice);

        } catch (Exception e) {
            log.error("Error updating invoice status to: {}", getInvoiceUpdateStatus(), e);

            throw new UpdateEntityException(
                    ExceptionCodesEnum.INVOICE_03_INVOICE_UPDATE.name(),
                    String.format("Error updating invoice with Id %s. Message: %s", invoiceId, e.getMessage()));
        }
    }
}
