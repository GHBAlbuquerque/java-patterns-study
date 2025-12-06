package com.patterns.external.database.id;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.UUID;

public class CustomLockIdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        final String prefix = "LOCK-";
        return prefix + UUID.randomUUID();
    }
}
