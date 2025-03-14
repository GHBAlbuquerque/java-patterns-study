package com.patterns.repository.invoice.repository;

import com.patterns.repository.invoice.orm.InvoiceORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceORM, String> {
}
