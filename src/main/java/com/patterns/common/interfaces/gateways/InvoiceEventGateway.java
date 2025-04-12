package com.patterns.common.interfaces.gateways;

import com.patterns.domain.entity.Invoice;

public interface InvoiceEventGateway {

    public void sendUpdateEvent(final Invoice invoice, final String eventStatus);
}
