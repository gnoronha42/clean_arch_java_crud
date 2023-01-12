package com.gabrielximenes.userscruds.domain.validation;

public interface Validation<T> {
    boolean validation(T value);

    void validationThrow(T value);
}
