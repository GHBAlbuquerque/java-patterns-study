package com.patterns.domain.validator.date;

import com.patterns.domain.validator.ChainValidator;
import com.patterns.domain.validator.ValidationResult;

import java.time.LocalDate;
import java.util.List;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV3000;

public class BusinessDayValidator extends ChainValidator<LocalDate> {

    private List<String> weekend = List.of("SATURDAY", "SUNDAY");

    @Override
    public ValidationResult validate(LocalDate value) {
        var weekDay = value.getDayOfWeek().name();

        if (weekend.contains(weekDay)) {
            return ValidationResult.invalid(MSINV3000);
        }

        return checkNext(value);
    }
}
