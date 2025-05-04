package com.patterns.domain.usecase;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.domain.entity.Invoice;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV0001;

public class GetInvoiceUseCaseImpl implements GetInvoiceUseCase {

    private final Logger log = LogManager.getLogger(GetInvoiceUseCaseImpl.class);

    @Override
    public Invoice getInvoiceById(String id, InvoiceGateway gateway) throws EntityNotFoundException {
        log.info("Retrieving invoice by id: {}", id);
        var result = gateway.getInvoiceById(id);

        if (result.isEmpty())
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result.get();
    }

    @Override
    public Invoice getInvoiceByBarcode(String barcode, InvoiceGateway gateway) throws EntityNotFoundException {
        log.info("Retrieving invoice by barcode: {}", barcode);
        var result = gateway.getInvoiceByBarcode(barcode);

        if (result == null)
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result;
    }

    @Override
    public IssuerView getInvoiceIssuerById(String id, InvoiceGateway gateway) throws EntityNotFoundException {
        log.info("Retrieving invoice issuer by id: {}", id);
        var result = gateway.getInvoiceIssuerById(id);

        if (result == null)
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result;
    }

    @Override
    public StatusView getInvoiceStatusById(String id, InvoiceGateway gateway) throws EntityNotFoundException {
        log.info("Retrieving invoice status by id: {}", id);
        var result = gateway.getInvoiceStatusById(id);

        if (result == null)
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result;
    }
}
