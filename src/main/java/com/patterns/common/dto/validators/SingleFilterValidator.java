package com.patterns.common.dto.validators;

import com.patterns.common.dto.request.InvoiceFilterRequest;
import com.patterns.common.dto.validators.annotations.ValidSingleFilter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SingleFilterValidator implements ConstraintValidator<ValidSingleFilter, InvoiceFilterRequest> {

    private static final String MESSAGE = "Only one type of filter should be provided: barcode, status, amount, date or issuer.";

    @Override
    public boolean isValid(InvoiceFilterRequest request, ConstraintValidatorContext context) {

        if (SingleFilterFinder.providedFilter(request) == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(MESSAGE)
                    .addConstraintViolation();

            return false;
        }

        return true;
    }
}