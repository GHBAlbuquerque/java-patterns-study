package com.patterns.communication.gateway;

import com.patterns.common.interfaces.datasources.LockRepository;
import com.patterns.common.interfaces.gateways.LockGateway;
import com.patterns.external.database.orm.LockORM;
import org.springframework.stereotype.Component;

@Component
public class LockGatewayImpl implements LockGateway {

    private final LockRepository repository;

    public LockGatewayImpl(LockRepository repository) {
        this.repository = repository;
    }

    @Override
    public LockORM acquireLock(LockORM lockORM) {
        return repository.save(lockORM);
    }
}
