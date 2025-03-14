package com.patterns.domain.validator;

public enum ValidationMessageEnum {

    MSPAY0001("MSPAY0001", "Payment not found"),
    MSPAY0002("MSPAY0002", "Payment already exists"),

    MSPAY1000("MSPAY1000", "Payment amount is under the minimum limit"),
    MSPAY1001("MSPAY1001", "Payment amount is over the maximum limit"),
    MSPAY1002("MSPAY1002", "Payment amount cannot be a negative number"),

    MSPAY2000("MSPAY2000", "Payment issuer is not known"),

    MSPAY3000("MSPAY3000", "Date cannot be a retroactive date"),
    MSPAY3001("MSPAY3001", "Date has to be business day");

    private final String code;
    private final String logMessage;

    ValidationMessageEnum(String code, String logMessage) {
        this.code = code;
        this.logMessage = logMessage;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public String getCode() {
        return code;
    }
}
