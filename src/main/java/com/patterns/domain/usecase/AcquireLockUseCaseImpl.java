package com.patterns.domain.usecase;

import com.patterns.communication.dto.request.CreateLockDTO;
import com.patterns.common.exception.ExceptionCodesEnum;
import com.patterns.common.exception.custom.LockAlreadyAcquiredException;
import com.patterns.common.interfaces.gateways.LockGateway;
import com.patterns.common.interfaces.usecases.AcquireLockUseCase;
import com.patterns.external.database.orm.LockORM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AcquireLockUseCaseImpl implements AcquireLockUseCase {

    private final Logger log = LoggerFactory.getLogger(AcquireLockUseCaseImpl.class);

    @Override
    public LockORM acquireLock(CreateLockDTO createLockDTO, LockGateway lockGateway)
        throws LockAlreadyAcquiredException {

        final String entityId = createLockDTO.entityId();
        final String userId = createLockDTO.userId();

        LockORM existingLock = lockGateway.getLock(entityId);

        if (existingLock == null || !isLockActive(existingLock)) {
            final var expiresAt = LocalDateTime.now().plusSeconds(createLockDTO.duration());
            final var newLockORM = new LockORM(userId, entityId, expiresAt);
            return lockGateway.createLock(newLockORM);
        }

        if (!existingLock.getUserId().equals(userId)) {
            log.warn("Lock for entityId {} already acquired by a different user {}. Current user {}.", entityId, existingLock.getUserId(), userId);
            throw new LockAlreadyAcquiredException(
                ExceptionCodesEnum.LOCK_01_ALREADY_ACQUIRED.name(),
                "Lock for entity " + entityId + " is already acquired by another user."
            );
        }

        log.info("Lock for entityId {} already acquired by same user '{}'. Returning existing lock.", entityId, userId);
        return existingLock;
    }

    @Override
    public Optional<LockORM> getAndValidateLock(String lockToken, String userId, LockGateway lockGateway) {
        LockORM lock = lockGateway.getLock(lockToken);
        if (lock != null && validateLock(lock, userId)) {
            return Optional.of(lock);
        }
        return Optional.empty();
    }
}
