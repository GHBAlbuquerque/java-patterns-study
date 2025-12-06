package com.patterns.communication.dto.response;

import com.patterns.domain.entity.Installment;
import com.patterns.domain.entity.Invoice;

import java.math.BigDecimal;
import java.util.List;

public record GetAgreementByIdDTO(
    String id,
    List<Installment> installments,
    List<Invoice> invoices,
    BigDecimal totalAmount
) {
}
