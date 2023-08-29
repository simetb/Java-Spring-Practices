package com.curso.springbootform.form.app.validation;

import com.curso.springbootform.form.app.models.domains.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidador implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario)target;

        ValidationUtils.rejectIfEmpty(errors, "nombre", "NotEmpty.user.nombre");

        if (!usuario.getIdentificador().matches("[0-9]{2}[.][\\\\d]{3}[.][\\\\d]{3}[-][A-Z]{1}")){
            errors.rejectValue("identificador","pattern.user.identificador");
        }
    }

}
