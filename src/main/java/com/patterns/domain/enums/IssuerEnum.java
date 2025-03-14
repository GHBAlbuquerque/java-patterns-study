package com.patterns.domain.enums;

import java.util.Arrays;

public enum IssuerEnum {

    PLAYBANK,
    TOPBANK,
    MOCKBANK;

    public static Boolean contains(IssuerEnum issuerEnum) {
        final var values = Arrays.stream(IssuerEnum.values()).map(Enum::name).toList();

        return values.contains(issuerEnum.name());
    }

}
