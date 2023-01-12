package com.gabrielximenes.userscruds.usecases.user;

import com.gabrielximenes.userscruds.domain.entities.UserEntity;
import com.gabrielximenes.userscruds.domain.exceptions.NotNullException;
import com.gabrielximenes.userscruds.domain.exceptions.UsernameInvalidException;
import com.gabrielximenes.userscruds.domain.record.UserRecord;
import com.gabrielximenes.userscruds.domain.repositories.UserRepository;
import com.gabrielximenes.userscruds.domain.usecases.user.SearchUser;
import com.gabrielximenes.userscruds.infra.datasources.UserDataSource;
import com.gabrielximenes.userscruds.infra.repositories.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class SearchUserTest {

    @Mock
    private UserDataSource userDataSource;

    private UserRepository userRepository;

    private SearchUser searchUser;


    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);

        userRepository = new UserRepositoryImpl(userDataSource);

        searchUser = new SearchUser(userRepository);
    }

    @Test
    void searchUserByIdReturnsUser() {
        
        when(userDataSource.findById(any(UUID.class))).thenReturn(Optional.of(new UserEntity()));

        assertInstanceOf(UserRecord.class, searchUser.searchUserById(UUID.randomUUID()));
    }
    
    @Test
    void searchUserByIdReturnsThrowIllegalArgumentException() {
        
        when(userDataSource.findById(any(UUID.class))).thenReturn(Optional.of(new UserEntity()));

        assertThrows(NotNullException.class,()-> searchUser.searchUserById(null));
    }

    @Test
    void searchUserByEmailReturnsUser() {
        
        when(userDataSource.findByEmail(any(String.class))).thenReturn(Optional.of(new UserEntity()));

        assertInstanceOf(UserRecord.class, searchUser.searchUserByEmail("exemplo@exemplo.com"));
    }

    @Test
    void searchUserByEmailReturnsThrowEmailInvalidException() {
        
        when(userDataSource.findByEmail(any(String.class))).thenReturn(Optional.of(new UserEntity()));

        assertThrows(UsernameInvalidException.class,()-> searchUser.searchUserByEmail("exemplo@exemplo"));
    }

    @Test
    void searchUserByUsernameReturnsUser() {
        
        when(userDataSource.findByUsername(any(String.class))).thenReturn(Optional.of(new UserEntity()));

        assertInstanceOf(UserRecord.class, searchUser.searchUserByUsername("exemplo"));
    }

    @Test
    void searchUserByUsernameReturnsThrowUsernameInvalidException() {
        
        when(userDataSource.findByUsername(any(String.class))).thenReturn(Optional.of(new UserEntity()));

        assertThrows(UsernameInvalidException.class,()-> searchUser.searchUserByUsername("exemplo@exemplo.com"));
    }

    @Test
    void searchUserAllReturnsListUser() {
        
        when(userDataSource.findAll()).thenReturn( new ArrayList<>());

        assertInstanceOf(List.class, searchUser.searchUserAll());
    }
}
