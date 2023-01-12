package com.gabrielximenes.userscruds.infra.validation.username;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UsernameUniqueValidatorForm.class)
public @interface UsernameUniqueValidationForm {

    String message() default "Username já cadastrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
