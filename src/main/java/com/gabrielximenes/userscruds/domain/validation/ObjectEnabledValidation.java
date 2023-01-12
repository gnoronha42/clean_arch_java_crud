package com.gabrielximenes.userscruds.domain.validation;

import  com.gabrielximenes.userscruds.domain.exceptions.ObjectDisabledException;

public class ObjectEnabledValidation implements Validation<Boolean> {

    @Override
    public boolean validation(Boolean value) {
        return value;
    }

    @Override
    public void validationThrow(Boolean value) {
        if (Boolean.TRUE.equals(validation(value))) return;
        throw new ObjectDisabledException("O valor está desativado!!!");
    }

}
