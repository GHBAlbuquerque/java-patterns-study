package com.patterns.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Bill(String id, String barcode, BigDecimal amount, LocalDate dueDate, LocalDate issueDate, String issuer) {

//    public Bill {
//        if (barcode == null || barcode.isBlank()) {
//            throw new IllegalArgumentException("Barcode cannot be null or empty");
//        }
//        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
//            throw new IllegalArgumentException("Amount must be greater than zero");
//        }
//        if (dueDate == null) {
//            throw new IllegalArgumentException("Due date cannot be null");
//        }
//        if (issueDate == null) {
//            throw new IllegalArgumentException("Issue date cannot be null");
//        }
//        if (issuer == null || issuer.isBlank()) {
//            throw new IllegalArgumentException("Issuer cannot be null or empty");
//        }
//    }
}
