package com.patterns.common.interfaces.usecases;

import com.patterns.common.dto.request.CreateLockDTO;
import com.patterns.external.database.orm.LockORM;

public interface AcquireLockUseCase {
    LockORM acquireLock(CreateLockDTO createLockDTO);
}
