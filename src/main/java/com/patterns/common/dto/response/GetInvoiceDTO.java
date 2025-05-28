package com.patterns.common.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GetInvoiceDTO(String id,
                            String barcode,
                            BigDecimal amount,
                            LocalDate dueDate,
                            LocalDate issueDate,
                            String issuer,
                            String status) implements IResponse {
}

