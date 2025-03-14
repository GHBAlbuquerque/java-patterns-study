package com.patterns.common.interfaces.datasources;

import com.patterns.external.orm.InvoiceORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceORM, String> {
}
