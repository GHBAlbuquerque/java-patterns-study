package com.patterns.communication.dto.message;

public record CustomQueueMessage<T>(
        CustomMessageHeaders headers,
        T body) {
}
