package com.patterns.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesMapper {

    @Value("${business.invoice.id.preffix}")
    private String invoiceIdPreffix;

    @Value("${business.invoice.id.suffix}")
    private String invoiceIdSuffix;

    @Value("${business.invoice.barcode.preffix}")
    private String invoiceBarcodePreffix;

    public String getInvoiceIdPreffix() {
        return invoiceIdPreffix;
    }

    public String getInvoiceIdSuffix() {
        return invoiceIdSuffix;
    }

    public String getInvoiceBarcodePreffix() {
        return invoiceBarcodePreffix;
    }
}
