package com.patterns.domain.validator;

public enum ValidationMessageEnum {

    MSINV0001("MSINV0001", "Invoice not found"),
    MSINV0002("MSINV0002", "Invoice already exists"),

    MSINV1000("MSINV1000", "Invoice amount is under the minimum limit"),
    MSINV1001("MSINV1001", "Invoice amount is over the maximum limit"),
    MSINV1002("MSINV1002", "Invoice amount cannot be a negative number"),

    MSINV2000("MSINV2000", "Invoice issuer is not known"),

    MSINV3000("MSINV3000", "Date cannot be a retroactive date"),
    MSINV3001("MSINV3001", "Date has to be business day");

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
