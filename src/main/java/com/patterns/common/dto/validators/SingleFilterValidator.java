package com.patterns.common.dto.validators;

import com.patterns.common.dto.request.InvoiceFilterRequest;
import com.patterns.common.dto.validators.annotations.ValidSingleFilter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashMap;
import java.util.Map;

public class SingleFilterValidator implements ConstraintValidator<ValidSingleFilter, InvoiceFilterRequest> {

    private static final String MESSAGE = "Only one type of filter should be provided: barcode, status, amount, date or issuer.";
    private static final Map<String, String> PROVIDED_VALUES = new HashMap<>();

    @Override
    public boolean isValid(InvoiceFilterRequest request, ConstraintValidatorContext context) {
        PROVIDED_VALUES.put("barcode", request.barcode());
        PROVIDED_VALUES.put("status", request.status());
        PROVIDED_VALUES.put("minimumAmount", request.minimumAmount() != null ? String.valueOf(request.minimumAmount()) : null);
        PROVIDED_VALUES.put("maximumAmount", request.maximumAmount() != null ? String.valueOf(request.maximumAmount()) : null);
        PROVIDED_VALUES.put("startDate", request.startDate() != null ? String.valueOf(request.startDate()) : null);
        PROVIDED_VALUES.put("endDate", request.endDate() != null ? String.valueOf(request.endDate()) : null);
        PROVIDED_VALUES.put("issuer", request.issuer());

        if (request.barcode() != null && !isSingleProvidedField("barcode")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(MESSAGE)
                    .addConstraintViolation();
            return false;
        }

        if (request.status() != null && !isSingleProvidedField("status")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(MESSAGE)
                    .addConstraintViolation();
            return false;
        }

        if (request.minimumAmount() != null && request.maximumAmount() != null
                && !isSingleProvidedPairOfFields("minimumAmount", "maximumAmount")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(MESSAGE)
                    .addConstraintViolation();
            return false;
        }

        if (request.startDate() != null && request.endDate() != null
                && !isSingleProvidedPairOfFields("startDate", "endDate")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(MESSAGE)
                    .addConstraintViolation();
            return false;
        }


        if (request.issuer() != null && !isSingleProvidedField("issuer")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(MESSAGE)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

    private boolean isSingleProvidedField(String fieldName) {
        final var control = PROVIDED_VALUES.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(fieldName))
                .filter(entry -> entry.getValue() != null)
                .toList();

        return control.isEmpty();
    }

    private boolean isSingleProvidedPairOfFields(String fieldName1, String fieldName2) {
        final var control = PROVIDED_VALUES.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(fieldName1) && !entry.getKey().equals(fieldName2))
                .filter(entry -> entry.getValue() != null)
                .toList();

        return control.isEmpty();
    }
}