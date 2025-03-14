package com.patterns.common.exception.model;

import java.util.List;

public class CustomException extends Exception {

    private final String code;
    private List<CustomError> errors;

    public CustomException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(String code, String message, List<CustomError> customErrors) {
        super(message);
        this.code = code;
        this.errors = customErrors;
    }

    public String getCode() {
        return code;
    }

    public List<CustomError> getErrors() {
        return errors;
    }
}
