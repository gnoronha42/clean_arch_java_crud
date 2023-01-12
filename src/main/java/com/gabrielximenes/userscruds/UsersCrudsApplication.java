package com.gabrielximenes.userscruds;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(
		info = @Info(
				title = "Users Crud Test",
				version = "1.0",
				description = "Documentação da api",
				contact = @Contact(
						name = "Gabriel Ximenes",
						email = "gabrielximenesnoronha@gmail.com"
				),
				license = @License(url = "https://github.com/pedroermarinho/ComandaLivre-API/blob/main/LICENSE",
				 name = "MIT"
				)
		)
)

public class UsersCrudsApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsersCrudsApplication.class, args);
	}

}