package com.patterns.common.dto.validators;

import com.patterns.common.dto.request.InvoiceFilterRequest;
import com.patterns.common.dto.validators.annotations.ValidSingleFilter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashMap;
import java.util.Map;

public class SingleFilterValidator implements ConstraintValidator<ValidSingleFilter, InvoiceFilterRequest> {

    private final String MESSAGE = "Only one type of filter should be provided: barcode, status, amount, date or issuer.";
    private final Map<String, String> PROVIDED_VALUES = new HashMap<>();

    @Override
    public boolean isValid(InvoiceFilterRequest request, ConstraintValidatorContext context) {
        PROVIDED_VALUES.put("barcode", request.barcode());
        PROVIDED_VALUES.put("status", request.status());
        PROVIDED_VALUES.put("minimumAmount", String.valueOf(request.minimumAmount()));
        PROVIDED_VALUES.put("maximumAmount", String.valueOf(request.maximumAmount()));
        PROVIDED_VALUES.put("startDate", String.valueOf(request.startDate()));
        PROVIDED_VALUES.put("endDate", String.valueOf(request.endDate()));
        PROVIDED_VALUES.put("issuer", request.issuer());

        if (request.barcode() != null) {
            //TODO
            final var values = PROVIDED_VALUES.entrySet().stream().filter(entry -> !entry.getKey().equals("barcode"))
                    .toList();

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Start date must be provided if end date is provided.")
                    .addConstraintViolation();
            return true;
        }


        return true;
    }
}