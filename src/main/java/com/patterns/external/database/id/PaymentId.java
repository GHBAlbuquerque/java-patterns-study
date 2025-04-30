package com.patterns.external.database.id;

import jakarta.persistence.Id;

import java.util.Objects;

public class PaymentId {

    @Id
    private String id;

    @Id
    private String invoiceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentId paymentId)) return false;
        return Objects.equals(id, paymentId.id) && Objects.equals(invoiceId, paymentId.invoiceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceId);
    }

    public PaymentId(String id, String invoiceId) {
        this.id = id;
        this.invoiceId = invoiceId;
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
}
