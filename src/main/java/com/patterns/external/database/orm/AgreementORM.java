package com.patterns.external.database.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity(name = "Agreement")
public class AgreementORM {

    @Id
    private String id;

    @NotNull
    private BigDecimal totalAmount;

    public AgreementORM() {
    }

    public AgreementORM(String id, BigDecimal totalAmount) {
        this.id = id;
        this.totalAmount = totalAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
