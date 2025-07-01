package com.patterns.domain.entity;

import com.patterns.domain.enums.InstallmentStatusEnum;
import com.patterns.domain.enums.PaymentMethodEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Installment {
    private int number;
    private LocalDate dueDate;
    private LocalDate paymentDate;

    private BigDecimal amount;
    private BigDecimal paidAmount;
    private BigDecimal interest;

    private InstallmentStatusEnum status;
    private PaymentMethodEnum paymentMethod;
    private String notes;

    public Installment(int number, LocalDate dueDate, LocalDate paymentDate, BigDecimal amount, BigDecimal paidAmount, BigDecimal interest, InstallmentStatusEnum status, PaymentMethodEnum paymentMethod, String notes) {
        this.number = number;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paidAmount = paidAmount;
        this.interest = interest;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.notes = notes;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
