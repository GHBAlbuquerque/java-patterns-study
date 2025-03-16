package com.patterns.common.interfaces.usecases;

import com.patterns.common.exception.custom.InvalidInvoiceException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.properties.PropertiesMapper;
import com.patterns.domain.entity.Invoice;

public interface CreateInvoiceUseCase {

    Invoice createInvoice(Invoice invoice, InvoiceGateway gateway, PropertiesMapper propertiesMapper) throws InvalidInvoiceException;

    String generateInvoiceId(PropertiesMapper propertiesMapper);

    String generateBarcode(PropertiesMapper propertiesMapper);

    void validateInvoiceRequest(Invoice invoice) throws InvalidInvoiceException;
}
