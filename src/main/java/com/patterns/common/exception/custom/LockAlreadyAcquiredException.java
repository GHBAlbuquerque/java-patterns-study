package com.patterns.common.exception.custom;

import com.patterns.common.exception.model.CustomException;
import java.util.Map;

public class LockAlreadyAcquiredException extends CustomException {
    public LockAlreadyAcquiredException(String code, String message) {
        super(code, message);
    }

    public LockAlreadyAcquiredException(String code, String message, Map<String, String> errors) {
        super(code, message, errors);
    }
}
