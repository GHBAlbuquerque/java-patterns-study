package com.patterns.domain.strategy;

import com.patterns.common.exception.ExceptionCodesEnum;
import com.patterns.common.exception.custom.UpdateEntityException;
import com.patterns.common.interfaces.gateways.InvoiceEventGateway;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.strategy.EventStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.patterns.domain.enums.PaymentEventsEnum.PAYMENT_CREATED;
import static com.patterns.domain.enums.StatusEnum.ACTIVE;

public class PaymentCancelledEventStrategyImpl implements EventStrategy {

    private final Logger log = LogManager.getLogger(PaymentCancelledEventStrategyImpl.class);

    private final InvoiceGateway invoiceGateway;
    private final InvoiceEventGateway invoiceEventGateway;

    public PaymentCancelledEventStrategyImpl(InvoiceGateway invoiceGateway, InvoiceEventGateway invoiceEventGateway) {
        this.invoiceGateway = invoiceGateway;
        this.invoiceEventGateway = invoiceEventGateway;
    }

    @Override
    public String getEventStatus() {
        return PAYMENT_CREATED;
    }

    @Override
    public String getInvoiceUpdateStatus() {
        return ACTIVE;
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

            propagateUpdate(invoiceEventGateway, invoice);

        } catch (Exception e) {
            log.error("Error updating invoice status to: {}", getInvoiceUpdateStatus(), e);

            throw new UpdateEntityException(
                    ExceptionCodesEnum.INVOICE_03_INVOICE_UPDATE.name(),
                    String.format("Error updating invoice with Id %s. Message: %s", invoiceId, e.getMessage()));
        }
    }
}
