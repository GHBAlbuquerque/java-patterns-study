package com.patterns.domain.validator.amount;

import com.patterns.domain.validator.ChainValidator;
import com.patterns.domain.validator.ValidationResult;

import java.math.BigDecimal;

import static com.patterns.domain.validator.ValidationMessageEnum.MSPAY1001;

public class MaximumAmountValidator extends ChainValidator<BigDecimal> {

    private BigDecimal maximumValue = BigDecimal.valueOf(999_000_000);

    @Override
    public ValidationResult validate(BigDecimal value) {
        if (maximumValue.compareTo(value) == -1) {
            return ValidationResult.invalid(MSPAY1001);
        }

        return checkNext(value);
    }
}
