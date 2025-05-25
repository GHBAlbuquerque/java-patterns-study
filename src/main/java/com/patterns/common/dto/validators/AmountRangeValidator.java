package com.patterns.common.dto.validators;

import com.patterns.common.dto.request.InvoiceFilterRequest;
import com.patterns.common.dto.validators.annotations.ValidAmountRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AmountRangeValidator implements ConstraintValidator<ValidAmountRange, InvoiceFilterRequest> {

    @Override
    public boolean isValid(InvoiceFilterRequest request, ConstraintValidatorContext context) {
        if (request.minimumAmount() != null && request.maximumAmount() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Maximum amount must be provided if minimum amount is provided.")
                    .addConstraintViolation();
            return false;
        }

        if (request.maximumAmount() != null && request.minimumAmount() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Minimum amount must be provided if maximum amount is provided.")
                    .addConstraintViolation();
            return false;
        }

        if (request.minimumAmount() != null && request.maximumAmount() != null && request.minimumAmount().compareTo(request.maximumAmount()) > 0) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Minimum amount must be less than or equal to maximum amount.")
                        .addConstraintViolation();
                return false;
            }


        return true;
    }
}