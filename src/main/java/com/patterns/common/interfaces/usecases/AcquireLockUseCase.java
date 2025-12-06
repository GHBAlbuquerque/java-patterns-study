package com.patterns.common.interfaces.usecases;

import com.patterns.communication.dto.request.CreateLockDTO;
import com.patterns.common.exception.custom.LockAlreadyAcquiredException;
import com.patterns.common.interfaces.gateways.LockGateway;
import com.patterns.external.database.orm.LockORM;

import java.time.LocalDateTime;

public interface AcquireLockUseCase {

    LockORM acquireLock(CreateLockDTO createLockDTO, LockGateway lockGateway) throws LockAlreadyAcquiredException;

    default boolean isLockActive(LockORM lock) {
        return lock != null && lock.getExpiresAt().isAfter(LocalDateTime.now());
    }
}
