package com.gabrielximenes.userscruds.usecases.user;

import com.gabrielximenes.userscruds.domain.entities.UserEntity;
import com.gabrielximenes.userscruds.domain.exceptions.ObjectNotFoundException;
import com.gabrielximenes.userscruds.domain.record.UserRecord;
import com.gabrielximenes.userscruds.domain.repositories.UserRepository;
import com.gabrielximenes.userscruds.domain.usecases.user.StatusUser;
import com.gabrielximenes.userscruds.infra.datasources.UserDataSource;
import com.gabrielximenes.userscruds.infra.repositories.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class StatusUserTest {

    @Mock
    private UserDataSource userDataSource;

    private UserRepository userRepository;

    private StatusUser statusUser;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);

        userRepository = new UserRepositoryImpl(userDataSource);

        statusUser = new StatusUser(userRepository);
    }

    @Test
    void disableUserReturnsUser() {
        
        when(userDataSource.save(any(UserEntity.class))).thenReturn(new UserEntity());
        when(userDataSource.findById(any(UUID.class))).thenReturn(Optional.of(new UserEntity()));

        assertInstanceOf(UserRecord.class, statusUser.disableUser(UUID.randomUUID()));
    }

    @Test
    void disableUserReturnsThrowsObjectNotFoundException() {
        
        when(userDataSource.save(any(UserEntity.class))).thenReturn(new UserEntity());

        assertThrows(ObjectNotFoundException.class,()-> statusUser.disableUser(UUID.randomUUID()));
    }

    @Test
    void enableUserReturnsUser() {
        
        when(userDataSource.save(any(UserEntity.class))).thenReturn(new UserEntity());
        when(userDataSource.findById(any(UUID.class))).thenReturn(Optional.of(new UserEntity()));

        assertInstanceOf(UserRecord.class, statusUser.enableUser(UUID.randomUUID()));
    }

    @Test
    void enableUserReturnsThrowsObjectNotFoundException() {
        
        when(userDataSource.save(any(UserEntity.class))).thenReturn(new UserEntity());

        assertThrows(ObjectNotFoundException.class,()-> statusUser.enableUser(UUID.randomUUID()));
    }


}
