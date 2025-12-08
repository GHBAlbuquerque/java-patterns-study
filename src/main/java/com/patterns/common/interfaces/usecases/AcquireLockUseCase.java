package com.patterns.common.interfaces.usecases;

import com.patterns.communication.dto.request.CreateLockDTO;
import com.patterns.common.exception.custom.LockAlreadyAcquiredException;
import com.patterns.external.database.orm.LockORM;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AcquireLockUseCase {

    LockORM acquireLock(CreateLockDTO createLockDTO) throws LockAlreadyAcquiredException;

    default boolean isLockActive(LockORM lock) {
        return lock != null && lock.getExpiresAt().isAfter(LocalDateTime.now());
    }

    default boolean validateLock(LockORM lock, String userId) {
        return isLockActive(lock) && lock.getUserId().equals(userId);
    }

    Optional<LockORM> getAndValidateLock(String lockToken, String userId);
}
