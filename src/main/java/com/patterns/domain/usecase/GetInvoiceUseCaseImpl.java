package com.patterns.domain.usecase;

import com.patterns.common.dto.request.InvoiceFilterRequest;
import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.domain.entity.Invoice;
import com.patterns.domain.enums.FilterEnum;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV0001;

public class GetInvoiceUseCaseImpl implements GetInvoiceUseCase {

    private final Logger log = LogManager.getLogger(GetInvoiceUseCaseImpl.class);

    @Override
    public Invoice getInvoiceById(final String id, final InvoiceGateway gateway) throws EntityNotFoundException {
        log.info("Retrieving invoice by id: {}", id);
        var result = gateway.getInvoiceById(id);

        if (result.isEmpty())
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result.get();
    }

    @Override
    public Invoice getInvoiceByBarcode(final String barcode, final InvoiceGateway gateway) throws EntityNotFoundException {
        log.info("Retrieving invoice by barcode: {}", barcode);
        var result = gateway.getInvoiceByBarcode(barcode);

        if (result == null)
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result;
    }

    @Override
    public IssuerView getInvoiceIssuerById(final String id, final InvoiceGateway gateway) throws EntityNotFoundException {
        log.info("Retrieving invoice issuer by id: {}", id);
        var result = gateway.getInvoiceIssuerById(id);

        if (result == null)
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result;
    }

    @Override
    public StatusView getInvoiceStatusById(final String id, final InvoiceGateway gateway) throws EntityNotFoundException {
        log.info("Retrieving invoice status by id: {}", id);
        var result = gateway.getInvoiceStatusById(id);

        if (result == null)
            throw new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());

        return result;
    }

    @Override
    public Page<Invoice> getInvoicesWithFilter(final InvoiceFilterRequest filter,
                                               final int page,
                                               final int size,
                                               final FilterEnum filterType,
                                               final InvoiceGateway gateway) {

        return switch (filterType) {
            case BARCODE -> Page.empty(); //TODO gateway.getInvoiceByBarcode(null);
            case ISSUER -> gateway.findAllByIssuer(filter.issuer(), PageRequest.of(page, size));
            case STATUS -> gateway.findAllByStatus(filter.status(), PageRequest.of(page, size));
            case ISSUE_DATE ->
                    gateway.findAllByIssueDateBetween(filter.startDate(), filter.endDate(), PageRequest.of(page, size));
            case AMOUNT ->
                    gateway.findAllByAmountBetween(filter.minimumAmount(), filter.maximumAmount(), PageRequest.of(page, size));
            default -> {
                log.warn("Invalid filter type provided: {}", filterType);
                throw new IllegalArgumentException("Invalid filter type: " + filterType);
            }
        };
    }
}
