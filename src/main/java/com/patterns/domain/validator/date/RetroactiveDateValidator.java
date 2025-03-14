package com.patterns.domain.validator.date;

import com.patterns.domain.validator.ChainValidator;
import com.patterns.domain.validator.ValidationResult;

import java.time.LocalDate;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV3000;

public class RetroactiveDateValidator extends ChainValidator<LocalDate> {

    @Override
    public ValidationResult validate(LocalDate value) {
        var today = LocalDate.now();

        if (value.isBefore(today)) {
            return ValidationResult.invalid(MSINV3000);
        }

        return checkNext(value);
    }
}
