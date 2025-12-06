package com.patterns.domain.usecase;

import com.patterns.common.dto.request.CreateLockDTO;
import com.patterns.common.interfaces.gateways.LockGateway;
import com.patterns.common.interfaces.usecases.AcquireLockUseCase;
import com.patterns.external.database.orm.LockORM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AcquireLockUseCaseImpl implements AcquireLockUseCase {

    private final Logger log = LoggerFactory.getLogger(AcquireLockUseCaseImpl.class);
    private final LockGateway lockGateway;

    public AcquireLockUseCaseImpl(LockGateway lockGateway) {
        this.lockGateway = lockGateway;
    }

    @Override
    public LockORM acquireLock(CreateLockDTO createLockDTO) {
        try {
            final var expiresAt = LocalDateTime.now().plusSeconds(createLockDTO.duration());
            final var lockORM = new LockORM(createLockDTO.userId(), createLockDTO.entityId(), expiresAt);
            return lockGateway.acquireLock(lockORM);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return null;
        }
    }
}
