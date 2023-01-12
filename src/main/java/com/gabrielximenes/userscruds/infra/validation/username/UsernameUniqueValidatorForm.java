package com.gabrielximenes.userscruds.infra.validation.username;

import com.gabrielximenes.userscruds.domain.usecases.user.SearchUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameUniqueValidatorForm implements ConstraintValidator<UsernameUniqueValidationForm, String> {

    private final SearchUser searchUser;

    public UsernameUniqueValidatorForm(SearchUser searchUser) {
        this.searchUser = searchUser;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !searchUser.existsByUsername(value);
    }
}
