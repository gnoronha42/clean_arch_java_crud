package com.gabrielximenes.userscruds.infra.forms;

import com.gabrielximenes.userscruds.infra.validation.email.EmailUniqueValidationForm;
import com.gabrielximenes.userscruds.infra.validation.email.EmailValidationForm;
import com.gabrielximenes.userscruds.infra.validation.username.UsernameUniqueValidationForm;
import com.gabrielximenes.userscruds.infra.validation.username.UsernameValidationForm;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public record UserForm(

        @Schema(description = "Nome do usuário", example = "Gabriel Ximenes", required = true)
        @NotBlank
        @Size(min = 3, max = 255)
        String name,

        @Schema(description = "Email do usuário", example = "exemplo@exemplo.com", required = true)
        @Email(message = "Email")
        @NotBlank
        @Size(min = 5, max = 255)
        @EmailValidationForm
        @EmailUniqueValidationForm
        String email,

        @Schema(description = "Nome de usuário", example = "exemplo", required = true)
        @NotBlank
        @Size(min = 3, max = 255)
        @UsernameValidationForm
        @UsernameUniqueValidationForm
        String username,

        @Schema(description = "Senha do usuário", example = "12345678", required = true)
        @NotBlank
        @Size(min = 8, max = 255)
        String password,

        @Schema(description = "Telefone do usuário", example = "+5500000000000")
        @Size(max = 16)
        String phone

) implements Serializable {

}
