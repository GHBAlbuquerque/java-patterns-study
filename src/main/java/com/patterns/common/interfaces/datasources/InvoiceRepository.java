package com.patterns.common.interfaces.datasources;

import com.patterns.external.database.orm.InvoiceORM;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<InvoiceORM, String> {

    Optional<InvoiceORM> findByBarcode(String barcode);

    IssuerView getIssuerById(String id);

    StatusView getStatusById(String id);

    Page<InvoiceORM> findAllByStatus(String status, PageRequest pageRequest);

    Page<InvoiceORM> findAllByIssuer(String issuer, PageRequest pageRequest);

    Page<InvoiceORM> findAllByIssueDateBetween(String startDate, String endDate, PageRequest pageRequest);

    Page<InvoiceORM> findAllByAmountBetween(BigDecimal minimumAmount, BigDecimal maximumAmount, PageRequest pageRequest);

}
