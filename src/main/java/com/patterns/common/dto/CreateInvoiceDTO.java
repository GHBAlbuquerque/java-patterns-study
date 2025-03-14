package com.patterns.common.entrypoint.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateInvoiceDTO(BigDecimal amount, LocalDate dueDate, LocalDate issueDate, String issuer) {
}

