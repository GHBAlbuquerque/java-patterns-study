package com.patterns.common.interfaces.usecases;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.domain.entity.Invoice;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;

public interface GetInvoiceUseCase {

    Invoice getInvoiceById(String id, InvoiceGateway gateway) throws EntityNotFoundException;

    Invoice getInvoiceByBarcode(String barcode, InvoiceGateway gateway) throws EntityNotFoundException;

    IssuerView getInvoiceIssuerById(String id, InvoiceGateway gateway) throws EntityNotFoundException;

    StatusView getInvoiceStatusById(String id, InvoiceGateway gateway) throws EntityNotFoundException;

}
