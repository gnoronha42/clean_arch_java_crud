package com.gabrielximenes.userscruds.presenter.controllers.user;

import com.gabrielximenes.userscruds.domain.record.UserRecord;
import com.gabrielximenes.userscruds.domain.usecases.user.RegisterUser;
import com.gabrielximenes.userscruds.infra.convert.UserConvert;
import com.gabrielximenes.userscruds.infra.forms.UserForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin("*")
@Tag(name = "User", description = "User options")
public class UserRegisterController {

    private final RegisterUser registerUser;
    private final UserConvert userConvert;

    public UserRegisterController(RegisterUser registerUser, UserConvert userConvert) {
        this.registerUser = registerUser;
        this.userConvert = userConvert;
    }

    @Operation(summary = "Register user", tags = {"User"})
    @PostMapping
    public ResponseEntity<UserRecord> registerUser(UserForm userForm) {
        final UserRecord user = registerUser.execute(userConvert.convert(userForm));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.id())
                .toUri();

        return ResponseEntity.created(uri).body(user);
    }

}
