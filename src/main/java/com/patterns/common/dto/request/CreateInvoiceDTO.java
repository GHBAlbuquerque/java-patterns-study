package com.patterns.common.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateInvoiceDTO(@NotNull BigDecimal amount, @NotNull LocalDate dueDate, @NotNull LocalDate issueDate, @NotBlank(message = "Issuer cannot be blank") String issuer) {
}

