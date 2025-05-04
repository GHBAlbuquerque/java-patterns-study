package com.patterns.common.interfaces.datasources;

import com.patterns.external.database.orm.InvoiceORM;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<InvoiceORM, String> {

    Optional<InvoiceORM> findByBarcode(String barcode);

    IssuerView getIssuerById(String id);

    StatusView getStatusById(String id);

}
