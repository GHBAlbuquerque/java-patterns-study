package com.patterns.domain.validator.issuer;

import com.patterns.domain.enums.IssuerEnum;
import com.patterns.domain.validator.ChainValidator;
import com.patterns.domain.validator.ValidationResult;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV2000;

public class KnownIssuersValidator extends ChainValidator<String> {
    @Override
    public ValidationResult validate(String value) {
        if (!IssuerEnum.contains(value)) {
            return ValidationResult.invalid(MSINV2000);
        }

        return checkNext(value);
    }
}
