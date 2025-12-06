package com.patterns.communication.dto.message;

public record CustomMessageHeaders(
        String invoiceId,
        String correlationId) {
}
