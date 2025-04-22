package com.patterns.common.interfaces.strategy;

import com.patterns.common.exception.custom.UpdateEntityException;
import com.patterns.common.interfaces.gateways.InvoiceEventGateway;
import com.patterns.domain.entity.Invoice;

public interface EventStrategy {

    String getEventStatus();

    String getInvoiceUpdateStatus();

    void updateInvoice(final String invoiceId) throws UpdateEntityException;

    default void propagateUpdate(InvoiceEventGateway invoiceEventGateway, Invoice invoice) {
        // Default implementation can be overridden if needed
        invoiceEventGateway.sendUpdateEvent(invoice, getInvoiceUpdateStatus());
    }
}
