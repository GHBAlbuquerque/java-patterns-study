package com.patterns.domain.usecase.strategy;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.domain.entity.Invoice;

public abstract class EventUseCaseAbstract {

    public abstract String getEventStatus();

    public abstract String getInvoiceUpdateStatus();

    public abstract void updateInvoice(final Invoice invoice, final InvoiceGateway invoiceGateway);
}
