package com.patterns.domain.entity;

import com.patterns.domain.enums.InstallmentStatusEnum;
import com.patterns.domain.enums.PaymentMethodEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Installment {

    private String agreementId;
    private int number;

    private LocalDate dueDate;
    private LocalDate paymentDate;

    private BigDecimal amount;
    private BigDecimal paidAmount;
    private BigDecimal interest;

    private InstallmentStatusEnum status;
    private PaymentMethodEnum paymentMethod;

    public Installment(String id, int number, LocalDate dueDate, LocalDate paymentDate, BigDecimal amount, BigDecimal paidAmount, BigDecimal interest, InstallmentStatusEnum status, PaymentMethodEnum paymentMethod) {
        this.agreementId = id;
        this.number = number;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paidAmount = paidAmount;
        this.interest = interest;
        this.status = status;
        this.paymentMethod = paymentMethod;
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
