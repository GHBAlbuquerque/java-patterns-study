package com.patterns.domain.usecase;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.domain.entity.Invoice;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV0001;

public class GetInvoiceUseCaseImpl implements GetInvoiceUseCase {

    @Override
    public Invoice getInvoiceById(String id, InvoiceGateway gateway) throws EntityNotFoundException {
        var result = gateway.getInvoiceById(id);

        if (result == null)
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result;
    }

    @Override
    public Invoice getInvoiceByBarcode(String barcode, InvoiceGateway gateway) throws EntityNotFoundException {
        var result = gateway.getInvoiceByBarcode(barcode);

        if (result == null)
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result;
    }
}
