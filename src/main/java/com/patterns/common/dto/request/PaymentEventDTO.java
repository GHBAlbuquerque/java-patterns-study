package com.patterns.common.dto.request;

public record PaymentEventDTO(String id,
                              String invoiceId,
                              String paymentStatus) {
}

