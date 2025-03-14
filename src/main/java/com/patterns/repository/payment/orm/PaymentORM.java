package com.patterns.repository.payment.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public record PaymentORM(@Id String id,
                      String barcode,
                      BigDecimal amount,
                      LocalDate dueDate,
                      LocalDate issueDate,
                      String issuer) {
}
