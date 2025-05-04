package com.patterns.common.interfaces.gateways;

import com.patterns.domain.entity.Invoice;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;

import java.util.Optional;

public interface InvoiceGateway {

    Optional<Invoice> getInvoiceById(String id);

    Invoice getInvoiceByBarcode(String barcode);

    Invoice saveInvoice(Invoice invoice);

    IssuerView getInvoiceIssuerById(String id);

    StatusView getInvoiceStatusById(String id);

}
