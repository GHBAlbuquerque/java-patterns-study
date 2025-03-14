package com.patterns.domain.validator.issuer;

import com.patterns.domain.enums.IssuerEnum;
import com.patterns.domain.validator.ChainValidator;
import com.patterns.domain.validator.ValidationResult;

import static com.patterns.domain.validator.ValidationMessageEnum.MSPAY2000;

public class KnownIssuersValidator extends ChainValidator<IssuerEnum> {
    @Override
    public ValidationResult validate(IssuerEnum value) {
        if (!IssuerEnum.contains(value)) {
            return ValidationResult.invalid(MSPAY2000);
        }

        return checkNext(value);
    }
}
