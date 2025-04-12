package com.patterns.domain.enums;

public class StatusEnum {
    public static final String ACTIVE = "ACTIVE";
    public static final String INACTIVE = "INACTIVE";
    public static final String PENDING = "PENDING";
    public static final String SUSPENDED = "SUSPENDED";
    public static final String PAID = "PAID";
    public static final String INCONSISTENT = "INCONSISTENT";

    public static Boolean contains(String status) {
        return status.equals(ACTIVE) || status.equals(INACTIVE) || status.equals(PENDING) || status.equals(SUSPENDED) || status.equals(PAID) || status.equals(INCONSISTENT);
    }
}
