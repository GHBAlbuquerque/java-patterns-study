package com.patterns.external.database.orm;

import com.patterns.domain.entity.Invoice;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AgreementORM {

    @Id
    private String id;

    @OneToMany
    private List<InstallmentORM> installments;

    @OneToMany
    private List<InvoiceORM> invoices;

    @NotNull
    private BigDecimal totalAmount;

    public AgreementORM() {
        this.installments = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    public AgreementORM(String id, List<InstallmentORM> installments, List<InvoiceORM> invoices, BigDecimal totalAmount) {
        this.id = id;
        this.installments = installments;
        this.invoices = invoices;
        this.totalAmount = totalAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<InstallmentORM> getInstallments() {
        return installments;
    }

    public void setInstallments(List<InstallmentORM> installments) {
        this.installments = installments;
    }

    public List<InvoiceORM> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceORM> invoices) {
        this.invoices = invoices;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
