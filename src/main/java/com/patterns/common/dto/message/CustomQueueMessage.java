package com.patterns.common.dto.message;

public record CustomQueueMessage<T>(
        CustomMessageHeaders headers,
        T body) {
}
