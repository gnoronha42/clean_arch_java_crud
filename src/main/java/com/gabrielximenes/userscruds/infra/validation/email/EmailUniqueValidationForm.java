package com.gabrielximenes.userscruds.infra.validation.email;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailUniqueValidatorForm.class)
public @interface EmailUniqueValidationForm {

    String message() default "Email já cadastrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
