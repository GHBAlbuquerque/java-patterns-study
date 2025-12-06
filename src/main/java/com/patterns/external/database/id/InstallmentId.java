package com.patterns.external.database.id;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InstallmentId implements Serializable {

    private String agreementId;
    private int number;

    public InstallmentId() {
    }

    public InstallmentId(String id, int number) {
        this.agreementId = id;
        this.number = number;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstallmentId that = (InstallmentId) o;
        return number == that.number && Objects.equals(agreementId, that.agreementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agreementId, number);
    }
}