package com.gabrielximenes.userscruds.domain.validation;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class UtilValidation {

    public static void statusEnableValidationThrow(boolean value) {
        final List<Validation<Boolean>> statusValidations = List.of(
                new NotNullValidation<>(),
                new ObjectEnabledValidation()
        );
        statusValidations.forEach(validation -> validation.validationThrow(value));
    }

    public static void idNotNullValidationThrow(UUID id) {
        final List<Validation<UUID>> validations = List.of(new NotNullValidation<>());
        validations.forEach(validation -> validation.validationThrow(id));
    }

    public static void objectNotNullValidationThrow(Object value) {
        final List<Validation<Object>> validations = List.of(new NotNullValidation<>());
        validations.forEach(validation -> validation.validationThrow(value));
    }

    public static void emailNotNullValidationThrow(String email) {
        final List<Validation<String>> validations = Arrays.asList(new NotNullValidation<>(), new EmailValidation());
        validations.forEach(validation -> validation.validationThrow(email));
    }

    public static void usernameNotNullValidationThrow(String username) {
        final List<Validation<String>> validations = Arrays.asList(new NotNullValidation<>(), new UsernameValidation());
        validations.forEach(validation -> validation.validationThrow(username));
    }
}
