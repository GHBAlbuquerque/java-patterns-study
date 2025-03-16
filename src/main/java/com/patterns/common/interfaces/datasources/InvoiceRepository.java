package com.patterns.common.interfaces.datasources;

import com.patterns.domain.entity.Invoice;
import com.patterns.external.orm.InvoiceORM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<InvoiceORM, String> {

    Optional<InvoiceORM> findByBarcode(String barcode);

}
