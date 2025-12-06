package com.patterns.communication.dto.request;

import java.math.BigDecimal;

public record CreateAgreementDTO(
        BigDecimal totalAmount
) {
}
