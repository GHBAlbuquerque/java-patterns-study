package com.patterns.external.database.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.patterns.external.database.id.CustomInvoiceId;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Invoice")
public class InvoiceORM {

    @Id
    @CustomInvoiceId
    private String id;

    @NotNull
    private String agreementId;

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

    @NotBlank
    private String status;

    public InvoiceORM(String id, String barcode, BigDecimal amount, LocalDate dueDate, LocalDate issueDate, String issuer, String status) {
        this.id = id;
        this.barcode = barcode;
        this.amount = amount;
        this.dueDate = dueDate;
        this.issueDate = issueDate;
        this.issuer = issuer;
        this.status = status;
    }

    public InvoiceORM() {
    }

    public String getId() {
        return id;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
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

    public String getStatus() {
        return status;
    }
}
