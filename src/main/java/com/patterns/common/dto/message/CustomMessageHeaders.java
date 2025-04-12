package com.patterns.common.dto.message;

public record CustomMessageHeaders(
        String invoiceId,
        String correlationId) {
}
