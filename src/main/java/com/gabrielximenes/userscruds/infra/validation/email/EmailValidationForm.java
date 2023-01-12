package com.gabrielximenes.userscruds.infra.validation.email;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidatorForm.class)
public @interface EmailValidationForm {

    String message() default "Email invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
