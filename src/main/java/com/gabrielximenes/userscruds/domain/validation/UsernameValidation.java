package com.gabrielximenes.userscruds.domain.validation;

import com.gabrielximenes.userscruds.domain.exceptions.UsernameInvalidException;

public class UsernameValidation implements Validation<String> {

    @Override
    public boolean validation(String username) {
        return !new EmailValidation().validation(username);
    }

    @Override
    public void validationThrow(String username) {
        if (Boolean.TRUE.equals(validation(username)))
            return;

        throw new UsernameInvalidException("Username Invalido !!!");
    }
}
