package com.patterns.common.dto.validators.annotations;

import com.patterns.common.dto.validators.AmountRangeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AmountRangeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAmountRange {
    String message() default "Invalid amount range.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}