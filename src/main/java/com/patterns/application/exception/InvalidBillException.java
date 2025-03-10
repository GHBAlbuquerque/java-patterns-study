package com.patterns.application.exception;

public class InvalidBillException extends RuntimeException {

    public InvalidBillException(String message) {
        super(message);
    }
}
