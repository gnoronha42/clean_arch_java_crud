package com.gabrielximenes.userscruds.infra.validation.username;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UsernameValidatorForm.class)
public @interface UsernameValidationForm {

    String message() default "Username invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
