package com.patterns.domain.validator.amount;

import com.patterns.domain.validator.ChainValidator;
import com.patterns.domain.validator.ValidationResult;

import java.math.BigDecimal;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV1000;

public class MinimumAmountValidator extends ChainValidator<BigDecimal> {

    private BigDecimal minimumValue = BigDecimal.valueOf(0.000_000_001);

    @Override
    public ValidationResult validate(BigDecimal value) {
        if (minimumValue.compareTo(value) == 1) {
            return ValidationResult.invalid(MSINV1000);
        }

        return checkNext(value);
    }
}
