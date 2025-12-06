package com.patterns.common.dto.request;

import java.math.BigDecimal;

public record CreateAgreementDTO(
        BigDecimal totalAmount
) {
}
