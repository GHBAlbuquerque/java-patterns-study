package com.patterns.domain.validator.date;

import com.patterns.domain.validator.ChainValidator;
import com.patterns.domain.validator.ValidationResult;

import java.time.LocalDate;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV3002;

public class FutureDateValidator extends ChainValidator<LocalDate> {

    @Override
    public ValidationResult validate(LocalDate value) {
        var today = LocalDate.now();

        if (today.isBefore(value)) {
            return ValidationResult.invalid(MSINV3002);
        }

        return checkNext(value);
    }
}
