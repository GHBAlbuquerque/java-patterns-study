package com.patterns.common.exception.custom;

public class InvalidInvoiceException extends RuntimeException {

    public InvalidInvoiceException(String message) {
        super(message);
    }
}
