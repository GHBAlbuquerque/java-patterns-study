package com.patterns.common.exception.custom;



import com.patterns.common.exception.model.CustomError;
import com.patterns.common.exception.model.CustomException;

import java.util.List;

public class EntityNotFoundException extends CustomException {

    public EntityNotFoundException(String code, String message) {
        super(code, message);
    }

    public EntityNotFoundException(String code, String message, List<CustomError> customErrors) {
        super(code, message, customErrors);
    }
}
