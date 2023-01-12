package com.gabrielximenes.userscruds.domain.usecases.user;

import com.gabrielximenes.userscruds.domain.record.UserRecord;
import com.gabrielximenes.userscruds.domain.repositories.UserRepository;
import com.gabrielximenes.userscruds.domain.validation.UtilValidation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class StatusUser {

    private final UserRepository userRepository;

    public StatusUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserRecord disableUser(UUID id) {
        UtilValidation.idNotNullValidationThrow(id);
        return userRepository.disable(id).fold(
                throwable -> {
                    throw throwable;
                },
                value -> value);
    }

    @Transactional
    public UserRecord enableUser(UUID id) {
        UtilValidation.idNotNullValidationThrow(id);
        return userRepository.enable(id).fold(
                throwable -> {
                    throw throwable;
                },
                value -> value);
    }
}
