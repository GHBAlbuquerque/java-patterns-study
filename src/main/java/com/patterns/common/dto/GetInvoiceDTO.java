package com.patterns.common.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GetInvoiceDTO(String id,
                            String barcode,
                            BigDecimal amount,
                            LocalDate dueDate,
                            LocalDate issueDate,
                            String issuer) {
}

