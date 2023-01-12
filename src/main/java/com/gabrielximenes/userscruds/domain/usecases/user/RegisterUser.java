package com.gabrielximenes.userscruds.domain.usecases.user;

import com.gabrielximenes.userscruds.domain.entities.UserEntity;
import com.gabrielximenes.userscruds.domain.record.UserRecord;
import com.gabrielximenes.userscruds.domain.repositories.UserRepository;
import com.gabrielximenes.userscruds.domain.validation.UtilValidation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterUser {

    private final UserRepository userRepository;



    public RegisterUser(UserRepository userRepository ) {
        this.userRepository = userRepository;

    }

    @Transactional
    public UserRecord execute(UserRecord userRegister) {
        UtilValidation.objectNotNullValidationThrow(userRegister);
        UtilValidation.emailNotNullValidationThrow(userRegister.email());

        final UserEntity userEntity = userRegister.toEntity();


        return userRepository.create(new UserRecord(userEntity)).fold(
                throwable -> {
                    throw throwable;
                },
                value -> value);
    }

}
