package com.patterns.domain.enums;

import java.util.Arrays;

public enum FilterEnum {

    BARCODE("barcode"),
    STATUS("status"),
    ISSUE_DATE("issueDate"),
    AMOUNT("amount"),
    ISSUER("name"),
    MULTIPLE("multiple");

    private String name;

    public static Boolean contains(String issuer) {
        final var values = Arrays.stream(FilterEnum.values()).map(Enum::name).toList();

        return values.contains(issuer);
    }

    FilterEnum(String name) {
        this.name = name;
    }
}
