package com.patterns.domain.strategy.entity;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.domain.entity.Agreement;
import com.patterns.domain.entity.Invoice;
import com.patterns.domain.enums.EntityEnum;

import java.util.List;

public class InvoiceDetailsStrategy extends Middleware {

    private final GetInvoiceUseCase getInvoiceUseCase;

    public InvoiceDetailsStrategy(GetInvoiceUseCase getInvoiceUseCase) {
        this.getInvoiceUseCase = getInvoiceUseCase;
    }

    @Override
    protected EntityEnum getEntityEnum() {
        return EntityEnum.INVOICE;
    }

    @Override
    public void handle(Agreement.Builder builder, String agreementId)
        throws EntityNotFoundException {
        List<Invoice> invoices = getInvoiceUseCase.getInvoicesByAgreementId(agreementId);
        builder.invoices(invoices);

        if (getNext().isPresent()) {
            getNext().get().handle(builder, agreementId);
        }
    }
}
