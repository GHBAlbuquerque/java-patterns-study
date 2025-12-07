package com.patterns.domain.strategy.event;

import com.patterns.common.exception.ExceptionCodesEnum;
import com.patterns.common.exception.custom.UpdateEntityException;
import com.patterns.common.interfaces.gateways.InvoiceEventGateway;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.strategy.EventStrategy;
import com.patterns.domain.enums.PaymentEventsEnum;
import com.patterns.domain.enums.StatusEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentSuspendedEventStrategyImpl implements EventStrategy {

    private final Logger log = LogManager.getLogger(PaymentSuspendedEventStrategyImpl.class);

    private final InvoiceGateway invoiceGateway;
    private final InvoiceEventGateway invoiceEventGateway;

    public PaymentSuspendedEventStrategyImpl(InvoiceGateway invoiceGateway, InvoiceEventGateway invoiceEventGateway) {
        this.invoiceGateway = invoiceGateway;
        this.invoiceEventGateway = invoiceEventGateway;
    }

    @Override
    public String getEventStatus() {
        return PaymentEventsEnum.PAYMENT_SUSPENDED.getEvent();
    }

    @Override
    public String getInvoiceUpdateStatus() {
        return StatusEnum.SUSPENDED.getStatus();
    }

    @Override
    public void updatePaymentStatusOnInvoice(String invoiceId) throws UpdateEntityException {
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
