package com.gabrielximenes.userscruds.usecases.user;

import com.gabrielximenes.userscruds.domain.repositories.UserRepository;
import com.gabrielximenes.userscruds.domain.usecases.user.UpdateUser;
import com.gabrielximenes.userscruds.infra.datasources.UserDataSource;
import com.gabrielximenes.userscruds.infra.repositories.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class UpdateUserTest {
    @Mock
    private UserDataSource userDataSource;

    private UserRepository userRepository;

    private UpdateUser updateUser;


    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);

        userRepository = new UserRepositoryImpl(userDataSource);

        updateUser = new UpdateUser(userRepository);
    }

}
