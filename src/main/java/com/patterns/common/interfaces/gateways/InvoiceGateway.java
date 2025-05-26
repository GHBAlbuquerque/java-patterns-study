package com.patterns.common.interfaces.gateways;

import com.patterns.domain.entity.Invoice;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public interface InvoiceGateway {

    Optional<Invoice> getInvoiceById(String id);

    Invoice getInvoiceByBarcode(String barcode);

    Invoice saveInvoice(Invoice invoice);

    IssuerView getInvoiceIssuerById(String id);

    StatusView getInvoiceStatusById(String id);

    Page<Invoice> findAllByStatus(String status, PageRequest pageRequest);

    Page<Invoice> findAllByIssuer(String issuer, PageRequest pageRequest);

    Page<Invoice> findAllByIssueDateBetween(LocalDate startDate, LocalDate endDate, PageRequest pageRequest);

    Page<Invoice> findAllByAmountBetween(BigDecimal minimumAmount, BigDecimal maximumAmount, PageRequest pageRequest);

}
