package com.patterns.common.interfaces.usecases;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.domain.entity.Invoice;

public interface UpdateInvoiceUseCase {
    Invoice updateInvoice(String invoiceId, Invoice invoice) throws EntityNotFoundException;
}
