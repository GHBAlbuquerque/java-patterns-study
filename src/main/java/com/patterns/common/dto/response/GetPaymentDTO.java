package com.patterns.common.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GetPaymentDTO {

    private String id;
    private String invoiceId;
    private BigDecimal amount;
    private LocalDate date;
    private String paymentMethod;
    private String status;

    public GetPaymentDTO(String id, String invoiceId, BigDecimal amount, LocalDate date, String paymentMethod, String status) {
        this.id = id;
        this.invoiceId = invoiceId;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
