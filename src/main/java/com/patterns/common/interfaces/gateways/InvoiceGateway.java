package com.patterns.common.interfaces.gateways;

import com.patterns.domain.entity.Invoice;

public interface InvoiceGateway {

    Invoice getInvoiceById(String id);

    Invoice getInvoiceByBarcode(String barcode);

    Invoice saveInvoice(Invoice invoice);

}
