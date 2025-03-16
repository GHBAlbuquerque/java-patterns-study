package com.patterns.external.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class InvoiceORM {

    @Id
    private String id;

    @NotNull
    private String barcode;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private LocalDate dueDate;

    @NotNull
    private LocalDate issueDate;

    @NotNull
    private String issuer;

    public InvoiceORM(String id, String barcode, BigDecimal amount, LocalDate dueDate, LocalDate issueDate, String issuer) {
        this.id = id;
        this.barcode = barcode;
        this.amount = amount;
        this.dueDate = dueDate;
        this.issueDate = issueDate;
        this.issuer = issuer;
    }

    public InvoiceORM() {
    }

    public String getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public String getIssuer() {
        return issuer;
    }
}
