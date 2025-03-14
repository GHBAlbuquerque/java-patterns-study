package com.patterns.domain.usecase;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.CreateInvoiceUseCase;
import com.patterns.domain.entity.Invoice;

public class CreateInvoiceUseCaseImpl implements CreateInvoiceUseCase {

    @Override
    public Invoice createInvoice(Invoice invoice, InvoiceGateway gateway) {
        return null;
    }
}
