package com.patterns.communication.dto.response;

import com.patterns.domain.enums.InstallmentStatusEnum;
import com.patterns.domain.enums.PaymentMethodEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GetInstallmentDTO(
    String agreementId,
    int number,
    LocalDate dueDate,
    LocalDate paymentDate,
    BigDecimal amount,
    BigDecimal paidAmount,
    BigDecimal interest,
    InstallmentStatusEnum status,
    PaymentMethodEnum paymentMethod
) {
}
