package com.patterns.common.interfaces.usecases;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.domain.entity.Invoice;

public interface UpdateInvoiceUseCase {
    Invoice updateInvoice(String invoiceId, Invoice invoice, InvoiceGateway invoiceGateway) throws EntityNotFoundException;
}
