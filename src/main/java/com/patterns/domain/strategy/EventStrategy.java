package com.patterns.domain.strategy;

public interface EventStrategy {

    String getEventStatus();

    String getInvoiceUpdateStatus();

    void updateInvoice(final String invoiceId);
}
