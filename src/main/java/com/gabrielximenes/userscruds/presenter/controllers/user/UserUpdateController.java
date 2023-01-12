package com.gabrielximenes.userscruds.presenter.controllers.user;

import com.gabrielximenes.userscruds.domain.record.UserRecord;
import com.gabrielximenes.userscruds.domain.usecases.user.UpdateUser;
import com.gabrielximenes.userscruds.infra.config.constants.PathRest;
import com.gabrielximenes.userscruds.infra.config.constants.UserPathRest;
import com.gabrielximenes.userscruds.infra.convert.UserConvert;
import com.gabrielximenes.userscruds.infra.forms.UserForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping(value = PathRest.API + PathRest.VERSION + UserPathRest.USER_UPDATE)
@Tag(name = "User", description = "User options")
public class UserUpdateController {

    private final UpdateUser updateUser;
    private final UserConvert userConvert;

    public UserUpdateController(UpdateUser updateUser, UserConvert userConvert) {
        this.updateUser = updateUser;
        this.userConvert = userConvert;
    }

    @Operation(summary = "Update user", tags = {"User"})
    @PutMapping("/{id}")
    public ResponseEntity<UserRecord> updateUser(@PathVariable UUID id, @Valid @RequestBody UserForm userForm) {
        final UserRecord user = updateUser.execute(id, userConvert.convert(userForm));
        return ResponseEntity.ok().body(user);
    }
}
