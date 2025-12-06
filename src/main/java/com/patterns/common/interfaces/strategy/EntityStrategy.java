package com.patterns.common.interfaces.strategy;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.domain.entity.Agreement;

public interface EntityStrategy {
    void handle(Agreement.Builder builder, String id) throws EntityNotFoundException;
}
