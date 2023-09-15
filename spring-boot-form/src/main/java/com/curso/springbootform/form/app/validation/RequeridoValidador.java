package com.curso.springbootform.form.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class RequeridoValidador implements ConstraintValidator<Requerido,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
//        if(value == null || value.isEmpty() || value.isBlank()){
//            return false;
//        }
        if(value == null || !StringUtils.hasText(value)){
            return false;
        }
        return true;
    }
}

