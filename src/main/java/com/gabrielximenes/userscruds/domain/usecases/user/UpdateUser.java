package com.gabrielximenes.userscruds.domain.usecases.user;

import com.gabrielximenes.userscruds.domain.record.UserRecord;
import com.gabrielximenes.userscruds.domain.repositories.UserRepository;
import com.gabrielximenes.userscruds.domain.validation.UtilValidation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UpdateUser {

    private final UserRepository userRepository;

    public UpdateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserRecord execute(UUID id, UserRecord userParam) {
        UtilValidation.idNotNullValidationThrow(id);
        UtilValidation.objectNotNullValidationThrow(userParam);
        UtilValidation.emailNotNullValidationThrow(userParam.email());
        UtilValidation.usernameNotNullValidationThrow(userParam.username());
        return userRepository.update(id, userParam).fold(
                throwable -> {
                    throw throwable;
                },
                value -> value);
    }
}
