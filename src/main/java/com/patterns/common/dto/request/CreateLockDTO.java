package com.patterns.common.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateLockDTO(
    @NotNull
    String userId,

    @NotNull
    String entityId,

    @NotNull
    Integer duration
) {
}
