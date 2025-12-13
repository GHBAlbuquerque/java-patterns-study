package com.patterns.common.interfaces.usecases;

import com.patterns.communication.dto.request.InvoiceFilterRequest;
import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.domain.entity.Invoice;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GetInvoiceUseCase {

    Invoice getInvoiceById(final String id) throws EntityNotFoundException;

    Invoice getInvoiceByBarcode(final String barcode) throws EntityNotFoundException;

    IssuerView getInvoiceIssuerById(final String id) throws EntityNotFoundException;

    StatusView getInvoiceStatusById(final String id) throws EntityNotFoundException;

    Page<Invoice> getInvoicesWithFilter(final InvoiceFilterRequest filter, final int page, final int size);

    List<Invoice> getInvoicesByAgreementId(String agreementId);
}
