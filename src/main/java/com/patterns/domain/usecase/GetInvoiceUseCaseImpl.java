package com.patterns.domain.usecase;

import com.patterns.communication.dto.request.InvoiceFilterRequest;
import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.domain.entity.Invoice;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV0001;

public class GetInvoiceUseCaseImpl implements GetInvoiceUseCase {

    private final Logger log = LogManager.getLogger(GetInvoiceUseCaseImpl.class);
    private final InvoiceGateway gateway;

    public GetInvoiceUseCaseImpl(InvoiceGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Invoice getInvoiceById(final String id) throws EntityNotFoundException {
        log.info("Retrieving invoice by id: {}", id);
        var result = gateway.getInvoiceById(id);

        if (result.isEmpty())
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result.get();
    }

    @Override
    public Invoice getInvoiceByBarcode(final String barcode) throws EntityNotFoundException {
        log.info("Retrieving invoice by barcode: {}", barcode);
        var result = gateway.getInvoiceByBarcode(barcode);

        if (result == null)
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result;
    }

    @Override
    public IssuerView getInvoiceIssuerById(final String id) throws EntityNotFoundException {
        log.info("Retrieving invoice issuer by id: {}", id);
        var result = gateway.getInvoiceIssuerById(id);

        if (result == null)
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result;
    }

    @Override
    public StatusView getInvoiceStatusById(final String id) throws EntityNotFoundException {
        log.info("Retrieving invoice status by id: {}", id);
        var result = gateway.getInvoiceStatusById(id);

        if (result == null)
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result;
    }

    @Override
    public Page<Invoice> getInvoicesWithFilter(final InvoiceFilterRequest filter,
                                               final int page,
                                               final int size) {
        log.info("Retrieving invoices with filter: {}", filter);
        return gateway.getInvoicesWithFilter(filter, PageRequest.of(page, size));
    }

    @Override
    public List<Invoice> getInvoicesByAgreementId(String agreementId) {
        log.info("Retrieving invoices for agreement id: {}", agreementId);
        return gateway.findAllByAgreementId(agreementId);
    }
}
