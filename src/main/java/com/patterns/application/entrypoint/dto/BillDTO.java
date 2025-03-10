package com.patterns.application.entrypoint.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BillDTO(String id, String barcode, BigDecimal amount, LocalDate dueDate, LocalDate issueDate,
                      String issuer) {
}

