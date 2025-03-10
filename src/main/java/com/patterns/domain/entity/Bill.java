package com.patterns.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Bill {

    private String id;
    private String barcode;
    private BigDecimal amount;
    private LocalDate dueDate;
    private LocalDate issueDate;
    private String issuer;

    public Bill(String id, String barcode, BigDecimal amount, LocalDate dueDate, LocalDate issueDate, String issuer) {
        this.id = id;
        this.barcode = barcode;
        this.amount = amount;
        this.dueDate = dueDate;
        this.issueDate = issueDate;
        this.issuer = issuer;
    }

    public Bill(BigDecimal amount, LocalDate dueDate, LocalDate issueDate, String issuer) {
        this.amount = amount;
        this.dueDate = dueDate;
        this.issueDate = issueDate;
        this.issuer = issuer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}

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
