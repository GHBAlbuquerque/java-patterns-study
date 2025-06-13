package com.patterns.domain.validator.barcode;

import com.patterns.domain.validator.ChainValidator;
import com.patterns.domain.validator.ValidationResult;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV2000;

public class BarcodeValidator extends ChainValidator<String> {

    static final String BARCODE_REGEX = "^0000[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    @Override
    public ValidationResult validate(String value) {
        if (value == null || value.isBlank() || !value.toLowerCase().matches(BARCODE_REGEX)) {
            return ValidationResult.invalid(MSINV2000);
        }

        return checkNext(value);
    }
}
