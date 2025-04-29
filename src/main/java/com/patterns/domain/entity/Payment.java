package com.patterns.domain.entity;

import com.patterns.domain.enums.PaymentMethodEnum;
import com.patterns.domain.enums.PaymentStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {

    private String id;
    private String invoiceId;
    private BigDecimal amount;
    private LocalDate date;
    private PaymentMethodEnum paymentMethod;
    private PaymentStatusEnum status;

    public Payment(String id, String invoiceId, BigDecimal amount, LocalDate date, PaymentMethodEnum paymentMethod, PaymentStatusEnum status) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public Payment(BigDecimal amount, LocalDate date, PaymentMethodEnum paymentMethod, PaymentStatusEnum status) {
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

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }
}
