package com.patterns.domain.validator.amount;

import com.patterns.domain.validator.ChainValidator;
import com.patterns.domain.validator.ValidationResult;

import java.math.BigDecimal;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV1002;

public class NegativeAmountValidator extends ChainValidator<BigDecimal> {

    @Override
    public ValidationResult validate(BigDecimal value) {
        if (BigDecimal.ZERO.compareTo(value) == 1) {
            return ValidationResult.invalid(MSINV1002);
        }

        return checkNext(value);
    }
}
