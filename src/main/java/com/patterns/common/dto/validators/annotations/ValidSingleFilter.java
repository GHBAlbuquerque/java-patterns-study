package com.patterns.common.dto.validators.annotations;

import com.patterns.common.dto.validators.SingleFilterValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SingleFilterValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSingleFilter {
    String message() default "Should provide only one filter.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}