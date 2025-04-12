package com.patterns.common.exception.custom;

import com.patterns.common.exception.model.CustomException;

import java.util.Map;

public class MessageCreationException extends CustomException {

    public MessageCreationException(String code, String message) {
        super(code, message);
    }

    public MessageCreationException(String code, String message, Map<String, String> errors) {
        super(code, message, errors);
    }
}