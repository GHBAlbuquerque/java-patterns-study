package com.patterns.common.interfaces.usecases;

import com.patterns.domain.entity.Invoice;

public interface CreateInvoiceUseCase {

    Invoice createInvoice(Invoice invoice);
}
