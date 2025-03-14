package com.patterns.common.interfaces.usecases;

import com.patterns.domain.entity.Invoice;

public interface GetInvoiceUseCase {

    Invoice getInvoiceById(String id);

    Invoice getInvoiceByBarcode(String barcode);

}
