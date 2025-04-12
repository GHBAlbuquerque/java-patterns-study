package com.patterns.common.exception.custom;

import com.patterns.common.exception.model.CustomException;

import java.util.Map;

public class InvalidMessageException extends CustomException {

    public InvalidMessageException(String code, String message) {
        super(code, message);
    }

    public InvalidMessageException(String code, String message, Map<String, String> errors) {
        super(code, message, errors);
    }
}