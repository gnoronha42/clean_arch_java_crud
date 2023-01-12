package com.gabrielximenes.userscruds.usecases.user;

import com.gabrielximenes.userscruds.domain.entities.UserEntity;
import com.gabrielximenes.userscruds.domain.exceptions.UsernameInvalidException;
import com.gabrielximenes.userscruds.domain.record.UserRecord;
import com.gabrielximenes.userscruds.domain.repositories.UserRepository;
import com.gabrielximenes.userscruds.domain.usecases.user.RegisterUser;
import com.gabrielximenes.userscruds.infra.datasources.UserDataSource;
import com.gabrielximenes.userscruds.infra.repositories.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class RegisterUserTest {

    @Mock
    private UserDataSource userDataSource;

    private UserRepository userRepository;

    private RegisterUser registerUser;





    @BeforeEach
    private void setUp() {
        MockitoAnnotations.openMocks(this);

        userRepository = new UserRepositoryImpl(userDataSource);

        registerUser = new RegisterUser(userRepository);
    }

//    @Test
//    void registerUserReturnsUser() {
//
//        when(userDataSource.save(any(UserEntity.class))).thenReturn(new UserEntity());
//        when(userDataSource.findById(any(UUID.class))).thenReturn(Optional.of(new UserEntity()));
//
//        final UserRecord user = new UserRecord("exemplo@exemplo.com","exemplo","exemplo","exemplo","exemplo");
//
//        assertInstanceOf(UserRecord.class, registerUser.execute(user));
//    }

    @Test
    void registerUserReturnsThrowsEmailInvalidException() {

        when(userDataSource.save(any(UserEntity.class))).thenReturn(new UserEntity());
        final UserRecord user = new UserRecord("exemplo@exemplo","exemplo","exemplo","exemplo","exemplo");


        assertThrows(UsernameInvalidException.class,()-> registerUser.execute(user));
    }
}
