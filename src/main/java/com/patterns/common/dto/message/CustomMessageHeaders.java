package com.patterns.common.dto.message;

public record CustomMessageHeaders(
        String messageId,
        String invoiceId,
        String correlationId,
        String clientId) {
}
