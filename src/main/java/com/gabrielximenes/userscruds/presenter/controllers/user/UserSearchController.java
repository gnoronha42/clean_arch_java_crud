package com.gabrielximenes.userscruds.presenter.controllers.user;

import com.gabrielximenes.userscruds.domain.record.UserRecord;
import com.gabrielximenes.userscruds.domain.record.UserRecord;
import com.gabrielximenes.userscruds.domain.usecases.user.SearchUser;
import com.gabrielximenes.userscruds.infra.config.constants.PathRest;
import com.gabrielximenes.userscruds.infra.config.constants.UserPathRest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin("*")

@Tag(name = "User", description = "User options")
public class UserSearchController {

    private final SearchUser searchUser;

    public UserSearchController(SearchUser searchUser) {
        this.searchUser = searchUser;
    }

    @Operation(summary = "User List", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "sucess",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserRecord.class)))
            )
    })
    @GetMapping
    public ResponseEntity<List<UserRecord>> searchUserAll() {
        final List<UserRecord> users = searchUser.searchUserAll();
        return ResponseEntity.ok().body(users);
    }

    @Operation(summary = "Find by  id", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(
                    responseCode = "200", description = "sucess",
                    content = @Content(schema = @Schema(implementation = UserRecord.class))
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserRecord> searchUserById(@PathVariable UUID id) {
        final UserRecord user = searchUser.searchUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @Operation(summary = "Find by  email", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(
                    responseCode = "200", description = "Sucess",
                    content = @Content(schema = @Schema(implementation = UserRecord.class))
            )
    })
    @GetMapping(UserPathRest.USER_SEARCH_EMAIL + "/{email}")
    public ResponseEntity<UserRecord> searchUserByEmail(@PathVariable String email) {
        final UserRecord user = searchUser.searchUserByEmail(email);
        return ResponseEntity.ok().body(user);
    }

    @Operation(summary = "Find by username", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User not found "),
            @ApiResponse(
                    responseCode = "200", description = "Sucess",
                    content = @Content(schema = @Schema(implementation = UserRecord.class))
            )
    })
    @GetMapping(UserPathRest.USER_SEARCH_USERNAME + "/{username}")
    public ResponseEntity<UserRecord> searchUserByUsername(@PathVariable String username) {
        final UserRecord user = searchUser.searchUserByUsername(username);
        return ResponseEntity.ok().body(user);
    }

}
