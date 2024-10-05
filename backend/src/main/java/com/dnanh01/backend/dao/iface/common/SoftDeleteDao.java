package com.dnanh01.backend.dao.iface.common;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.dnanh01.backend.exception.EntityOperationException;

public interface SoftDeleteDao<T> {
    void softDelete(UUID id) throws EntityOperationException;

    void restoreFromSoftDelete(UUID id) throws EntityOperationException;

    Optional<T> findByIdIncludingDeleted(UUID id) throws EntityOperationException;

    List<T> findAllIncludingDeleted(Map<String, Object> filterParams) throws EntityOperationException;
}