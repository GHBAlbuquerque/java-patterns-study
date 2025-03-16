package com.patterns.domain.validator;

public enum ValidationMessageEnum {

    MSINV0001("MSINV0001", "Invoice not found"),
    MSINV0002("MSINV0002", "Invoice already exists"),
    MSINV0003("MSINV0003", "Invoice creation request is invalid"),

    MSINV1000("MSINV1000", "Amount is under the minimum limit"),
    MSINV1001("MSINV1001", "Amount is over the maximum limit"),
    MSINV1002("MSINV1002", "Amount cannot be a negative number"),

    MSINV2000("MSINV2000", "Issuer is not known"),

    MSINV3000("MSINV3000", "Invoice dates have to be business days"),
    MSINV3001("MSINV3001", "Due Date cannot be a retroactive date"),
    MSINV3002("MSINV3002", "Issue Date cannot be a future date");

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
