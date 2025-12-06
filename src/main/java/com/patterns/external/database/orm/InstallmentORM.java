package com.patterns.external.database.orm;

import com.patterns.domain.enums.InstallmentStatusEnum;
import com.patterns.domain.enums.PaymentMethodEnum;
import com.patterns.external.database.id.InstallmentId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Installment")
public class InstallmentORM {

    @EmbeddedId
    private InstallmentId id;

    @NotNull
    private LocalDate dueDate;

    @NotNull
    private LocalDate paymentDate;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private BigDecimal paidAmount;

    @NotNull
    private BigDecimal interest;

    @NotNull
    @Enumerated(EnumType.STRING)
    private InstallmentStatusEnum status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;

    public InstallmentORM() {
    }
    public InstallmentORM(InstallmentId id, LocalDate dueDate, LocalDate paymentDate, BigDecimal amount,
                          BigDecimal paidAmount, BigDecimal interest, InstallmentStatusEnum status,
                          PaymentMethodEnum paymentMethod) {
        this.id = id;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paidAmount = paidAmount;
        this.interest = interest;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public InstallmentId getId() {
        return id;
    }

    public void setId(InstallmentId id) {
        this.id = id;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public InstallmentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(InstallmentStatusEnum status) {
        this.status = status;
    }

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
