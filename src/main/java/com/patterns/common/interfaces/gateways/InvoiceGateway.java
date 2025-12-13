package com.patterns.common.interfaces.gateways;

import com.patterns.communication.dto.request.InvoiceFilterRequest;
import com.patterns.domain.entity.Invoice;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface InvoiceGateway {

    Optional<Invoice> getInvoiceById(String id);

    Invoice getInvoiceByBarcode(String barcode);

    Invoice saveInvoice(Invoice invoice);

    IssuerView getInvoiceIssuerById(String id);

    StatusView getInvoiceStatusById(String id);

    List<Invoice> findAllByAgreementId(String agreementId);

    Page<Invoice> getInvoicesWithFilter(InvoiceFilterRequest filter, PageRequest pageRequest);
}
