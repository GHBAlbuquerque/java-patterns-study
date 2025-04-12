package com.patterns.domain.strategy;

import com.patterns.common.exception.custom.UpdateEntityException;

public interface EventStrategy {

    String getEventStatus();

    String getInvoiceUpdateStatus();

    void updateInvoice(final String invoiceId) throws UpdateEntityException;
}
