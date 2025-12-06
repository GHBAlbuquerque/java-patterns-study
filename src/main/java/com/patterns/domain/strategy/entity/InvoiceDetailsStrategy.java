package com.patterns.domain.strategy.entity;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.domain.entity.Agreement;
import com.patterns.domain.entity.Invoice;
import com.patterns.domain.enums.EntityEnum;

import java.util.List;

public class InvoiceDetailsStrategy extends Middleware {

    private final GetInvoiceUseCase getInvoiceUseCase;
    private final InvoiceGateway invoiceGateway;

    public InvoiceDetailsStrategy(GetInvoiceUseCase getInvoiceUseCase, InvoiceGateway invoiceGateway) {
        this.getInvoiceUseCase = getInvoiceUseCase;
        this.invoiceGateway = invoiceGateway;
    }

    @Override
    protected EntityEnum getEntityEnum() {
        return EntityEnum.INVOICE;
    }

    @Override
    public void handle(Agreement.Builder builder, String agreementId) {
        List<Invoice> invoices = getInvoiceUseCase.getInvoicesByAgreementId(agreementId, invoiceGateway);
        builder.invoices(invoices);

        if (getNext().isPresent()) {
            getNext().get().handle(builder, agreementId);
        }
    }
}
