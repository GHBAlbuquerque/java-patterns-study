package com.patterns.common.dto.response;

public class GetPaymentMethodDTO {

    private String id;
    private String invoiceId;
    private String paymentMethod;

    public GetPaymentMethodDTO(String id, String invoiceId, String paymentMethod) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.paymentMethod = paymentMethod;
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
}
