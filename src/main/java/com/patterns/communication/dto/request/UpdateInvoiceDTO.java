package com.patterns.communication.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateInvoiceDTO(
        @NotNull(message = "Amount cannot be null")
        @Positive(message = "Amount must be positive")
        BigDecimal amount,

        @NotNull(message = "Due date cannot be null")
        LocalDate dueDate,

        @NotNull(message = "Issue date cannot be null")
        LocalDate issueDate,

        @NotBlank(message = "Issuer cannot be blank")
        String issuer,

        @NotBlank(message = "Status cannot be blank")
        String status
) {
}
