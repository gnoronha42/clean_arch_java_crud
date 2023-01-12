package com.gabrielximenes.userscruds.presenter.controllers.user;

import com.gabrielximenes.userscruds.domain.record.UserRecord;
import com.gabrielximenes.userscruds.domain.usecases.user.StatusUser;
import com.gabrielximenes.userscruds.infra.config.constants.PathRest;
import com.gabrielximenes.userscruds.infra.config.constants.UserPathRest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")

@Tag(name = "User", description = "user options")
public class UserStatusController {

    private final StatusUser statusUser;

    public UserStatusController(StatusUser statusUser) {
        this.statusUser = statusUser;
    }

    @Operation(summary = "Disabled User", tags = {"User"})
    @PatchMapping("/{id}")
    public ResponseEntity<UserRecord> disableUser(@PathVariable UUID id) {
        final UserRecord user = statusUser.disableUser(id);
        return ResponseEntity.ok().body(user);
    }
}
