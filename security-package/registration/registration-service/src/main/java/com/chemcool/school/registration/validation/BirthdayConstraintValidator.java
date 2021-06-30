package com.chemcool.school.registration.validation;

import com.chemcool.school.registration.annotations.ValidBirthday;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class BirthdayConstraintValidator implements ConstraintValidator<ValidBirthday, LocalDate> {
    @Override
    public void initialize(ValidBirthday constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        if (date == null) {
            return true;
        }
        int age = Period.between(date, LocalDate.now()).getYears();
        return age > 6 && age < 100;
    }
}
