package com.patterns.external.database.orm;

import com.patterns.external.database.id.PaymentId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "payment")
@IdClass(PaymentId.class)
public class PaymentORM {

    @Id
    private String id;

    @Id
    private String invoiceId;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private LocalDate date;

    @NotNull
    private String paymentMethod;

    @NotNull
    private String status;

    public PaymentORM(String id, String invoiceId, BigDecimal amount, LocalDate date, String paymentMethod, String status) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public PaymentORM(BigDecimal amount, LocalDate date, String paymentMethod, String status) {
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
