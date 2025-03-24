package com.sendEmailSpringBoot.demo.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
public @interface AgeValidation {
    String message() default "Must be at least 18 years old";
    int min();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
