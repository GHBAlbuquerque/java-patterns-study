package com.patterns.communication.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GetInvoiceDTO(String id,
                            String agreementId,
                            String barcode,
                            BigDecimal amount,
                            LocalDate dueDate,
                            LocalDate issueDate,
                            String issuer,
                            String status) implements IResponse {
}

