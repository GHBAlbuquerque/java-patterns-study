package com.patterns.common.interfaces.gateways;

import com.patterns.external.database.orm.LockORM;

public interface LockGateway {
    LockORM acquireLock(LockORM lockORM);
}
