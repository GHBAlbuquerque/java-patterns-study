package com.patterns.communication.dto.request;

import com.patterns.domain.enums.InstallmentStatusEnum;
import com.patterns.domain.enums.PaymentMethodEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateInstallmentDTO {

    @NotBlank
    private String agreementId;

    @NotNull
    private LocalDate dueDate;
    private LocalDate paymentDate;

    @NotNull
    @Positive
    private BigDecimal amount;
    private BigDecimal paidAmount;
    private BigDecimal interest;

    private InstallmentStatusEnum status = InstallmentStatusEnum.PENDING;
    private PaymentMethodEnum paymentMethod;

    public CreateInstallmentDTO(String agreementId, LocalDate dueDate, LocalDate paymentDate, BigDecimal amount, BigDecimal paidAmount, BigDecimal interest, InstallmentStatusEnum status, PaymentMethodEnum paymentMethod) {
        this.agreementId = agreementId;
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
