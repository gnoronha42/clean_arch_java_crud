package com.gabrielximenes.userscruds.infra.validation.email;

import com.gabrielximenes.userscruds.domain.validation.EmailValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidatorForm implements ConstraintValidator<EmailValidationForm, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return new EmailValidation().validation(value);
    }
}
