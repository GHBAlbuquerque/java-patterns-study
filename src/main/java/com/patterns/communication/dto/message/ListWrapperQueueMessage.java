package com.patterns.communication.dto.message;

import java.util.List;

public record ListWrapperQueueMessage<T>(
        List<CustomQueueMessage<T>> messages) {
}
