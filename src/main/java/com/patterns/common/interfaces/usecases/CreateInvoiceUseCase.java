package com.patterns.common.interfaces.usecases;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.domain.entity.Invoice;

public interface CreateInvoiceUseCase {

    Invoice createInvoice(Invoice invoice, InvoiceGateway gateway);
}
