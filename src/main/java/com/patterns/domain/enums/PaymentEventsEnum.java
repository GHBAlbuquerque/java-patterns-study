package com.patterns.domain.enums;

public enum PaymentEventsEnum {
    PAYMENT_CREATED("CREATED"),
    PAYMENT_CANCELLED("CANCELLED"),
    PAYMENT_PENDING("PENDING"),
    PAYMENT_SUSPENDED("SUSPENDED"),
    PAYMENT_RECEIVED("RECEIVED"),
    PAYMENT_INCONSISTENT("INCONSISTENT");

    private final String event;

    PaymentEventsEnum(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
