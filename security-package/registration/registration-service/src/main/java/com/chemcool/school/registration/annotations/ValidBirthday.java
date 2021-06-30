package com.chemcool.school.registration.annotations;

import com.chemcool.school.registration.validation.BirthdayConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = BirthdayConstraintValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ValidBirthday {
    String message() default "Invalid Age";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
