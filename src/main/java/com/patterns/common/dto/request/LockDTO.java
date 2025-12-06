package com.patterns.common.dto.request;

import jakarta.validation.constraints.NotNull;

public class LockDTO {

    @NotNull
    private String userId;

    @NotNull
    private String entityId;

    @NotNull
    private Integer duration;
}
