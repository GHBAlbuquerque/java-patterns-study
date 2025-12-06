package com.patterns.communication.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateInvoiceDTO(
        @NotBlank(message = "Agreement ID cannot be blank") String agreementId,
        @NotNull BigDecimal amount,
        @NotNull LocalDate dueDate,
        @NotNull LocalDate issueDate,
        @NotBlank(message = "Issuer cannot be blank") String issuer) {
}

