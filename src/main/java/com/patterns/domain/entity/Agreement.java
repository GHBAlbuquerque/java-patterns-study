package com.patterns.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Agreement {
    private String id;
    private List<Installment> installments;
    private List<Invoice> invoices;
    private BigDecimal totalAmount;

    private Agreement(Builder builder) {
        this.id = builder.id;
        this.installments = builder.installments;
        this.invoices = builder.invoices;
        this.totalAmount = builder.totalAmount;
    }

    public static class Builder {
        private String id;
        private List<Installment> installments = new ArrayList<>();
        private List<Invoice> invoices = new ArrayList<>();
        private BigDecimal totalAmount;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder addInstallment(Installment installment) {
            this.installments.add(installment);
            return this;
        }

        public Builder installments(List<Installment> installments) {
            this.installments = installments;
            return this;
        }

        public Builder addInvoice(Invoice invoice) {
            this.invoices.add(invoice);
            return this;
        }

        public Builder invoices(List<Invoice> invoices) {
            this.invoices = invoices;
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Agreement build() {
            return new Agreement(this);
        }
    }
}
