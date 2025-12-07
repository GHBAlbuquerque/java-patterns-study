package com.patterns.communication.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateAgreementDTO(
        @NotNull(message = "Total amount cannot be null")
        @Positive(message = "Total amount must be positive")
        BigDecimal totalAmount
) {
}
