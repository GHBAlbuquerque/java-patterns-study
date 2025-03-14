package com.patterns.domain.validator;

public final class ValidationResult {

    private final boolean isValid;
    private final ValidationMessageEnum validationMessageEnum;

    public ValidationResult(boolean isValid, ValidationMessageEnum validationMessageEnum) {
        this.isValid = isValid;
        this.validationMessageEnum = validationMessageEnum;
    }

    public static ValidationResult valid() {
        return new ValidationResult(true, null);
    }

    public static ValidationResult invalid(ValidationMessageEnum customErrorEnum) {
        return new ValidationResult(false, customErrorEnum);
    }

    public boolean notValid() {
        return !isValid;
    }

    public ValidationMessageEnum getError() {
        return validationMessageEnum;
    }
}
