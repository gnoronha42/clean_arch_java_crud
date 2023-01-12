package com.gabrielximenes.userscruds.domain.repositories;

import io.vavr.control.Either;

import java.util.List;
import java.util.UUID;

public interface GenericRepository<D> {
    List<D> findAll();

    Either<RuntimeException, D> findById(UUID id);

    Either<RuntimeException, D> create(D param);

    Either<RuntimeException, D> update(UUID id, D param);

    Either<RuntimeException, D> disable(UUID id);

    Either<RuntimeException, D> enable(UUID id);

    Either<RuntimeException, Long> count();
}
