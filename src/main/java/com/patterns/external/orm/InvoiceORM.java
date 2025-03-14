package com.patterns.external.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public record InvoiceORM(@Id String id,
                         String barcode,
                         BigDecimal amount,
                         LocalDate dueDate,
                         LocalDate issueDate,
                         String issuer) {
}
