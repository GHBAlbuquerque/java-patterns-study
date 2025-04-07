package com.patterns.domain.usecase.eventstrategy;

import com.patterns.common.interfaces.gateways.InvoiceGateway;

public abstract class EventUseCaseAbstract {

    protected final InvoiceGateway invoiceGateway;

    protected EventUseCaseAbstract(InvoiceGateway invoiceGateway) {
        this.invoiceGateway = invoiceGateway;
    }

    public abstract String getEventStatus();

    public abstract String getInvoiceUpdateStatus();

    public abstract void updateInvoice(final String invoiceId);
}
