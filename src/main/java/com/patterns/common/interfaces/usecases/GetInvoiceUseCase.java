package com.patterns.common.interfaces.usecases;

import com.patterns.common.dto.request.InvoiceFilterRequest;
import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.domain.entity.Invoice;
import com.patterns.domain.enums.FilterEnum;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;
import org.springframework.data.domain.Page;

public interface GetInvoiceUseCase {

    Invoice getInvoiceById(final String id, final InvoiceGateway gateway) throws EntityNotFoundException;

    Invoice getInvoiceByBarcode(final String barcode, final InvoiceGateway gateway) throws EntityNotFoundException;

    IssuerView getInvoiceIssuerById(final String id, final InvoiceGateway gateway) throws EntityNotFoundException;

    StatusView getInvoiceStatusById(final String id, final InvoiceGateway gateway) throws EntityNotFoundException;

    Page<Invoice> getInvoicesWithFilter(final InvoiceFilterRequest filter, final int page, final int size, final FilterEnum filterType, final InvoiceGateway gateway);

}
