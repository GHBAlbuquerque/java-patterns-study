package com.patterns.common.interfaces.strategy;

import com.patterns.domain.entity.Agreement;

public interface EntityStrategy {
    void handle(Agreement.Builder builder, String id);
}
