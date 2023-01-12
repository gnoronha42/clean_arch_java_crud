package com.gabrielximenes.userscruds.domain.repositories;

import com.gabrielximenes.userscruds.domain.record.UserRecord;
import io.vavr.control.Either;

public interface UserRepository extends GenericRepository<UserRecord> {

    Either<RuntimeException, UserRecord> findByEmail(String email);

    Either<RuntimeException, UserRecord> findByUsername(String username);

    Either<RuntimeException, Boolean> existsByUsername(String username);

    Either<RuntimeException, Boolean> existsByEmail(String email);
}
