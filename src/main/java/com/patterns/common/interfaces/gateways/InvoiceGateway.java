package com.patterns.common.interfaces.gateways;

import com.patterns.domain.entity.Invoice;

import java.util.Optional;

public interface InvoiceGateway {

    Optional<Invoice> getInvoiceById(String id);

    Invoice getInvoiceByBarcode(String barcode);

    Invoice saveInvoice(Invoice invoice);

}
