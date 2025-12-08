package com.patterns.domain.enums;

import java.util.Arrays;

public enum StatusEnum {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    PENDING("PENDING"),
    SUSPENDED("SUSPENDED"),
    PAID("PAID"),
    INCONSISTENT("INCONSISTENT");

    private final String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static Boolean contains(String status) {
        return Arrays.stream(StatusEnum.values())
                .anyMatch(s -> s.getStatus().equals(status));
    }
}
