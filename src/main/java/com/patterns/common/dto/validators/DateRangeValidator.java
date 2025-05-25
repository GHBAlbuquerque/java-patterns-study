package com.patterns.common.dto.validators;

import com.patterns.common.dto.request.InvoiceFilterRequest;
import com.patterns.common.dto.validators.annotations.ValidDateRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, InvoiceFilterRequest> {

    @Override
    public boolean isValid(InvoiceFilterRequest request, ConstraintValidatorContext context) {
        if (request.startDate() != null && request.endDate() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("End date must be provided if start date is provided.")
                    .addConstraintViolation();
            return false;
        }

        if (request.endDate() != null && request.startDate() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Start date must be provided if end date is provided.")
                    .addConstraintViolation();
            return false;
        }

        if (request.startDate() != null && request.endDate() != null && request.endDate().isBefore(request.startDate())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("End date must be after start date.")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
