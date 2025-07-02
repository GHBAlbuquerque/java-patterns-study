package com.patterns.external.database.orm;

import com.patterns.domain.enums.InstallmentStatusEnum;
import com.patterns.domain.enums.PaymentMethodEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class InstallmentORM {

    @Id
    private String id;

    @NotNull
    private int number;

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
    private InstallmentStatusEnum status;

    @NotNull
    private PaymentMethodEnum paymentMethod;

    public InstallmentORM() {
    }

    public InstallmentORM(int number, LocalDate dueDate, LocalDate paymentDate, BigDecimal amount, BigDecimal paidAmount, BigDecimal interest, InstallmentStatusEnum status, PaymentMethodEnum paymentMethod, String notes) {
        this.number = number;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paidAmount = paidAmount;
        this.interest = interest;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
