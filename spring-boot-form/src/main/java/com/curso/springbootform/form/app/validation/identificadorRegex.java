package com.curso.springbootform.form.app.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = identificadorRegexValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD})
public @interface identificadorRegex {
    String message() default "Identificador Invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
