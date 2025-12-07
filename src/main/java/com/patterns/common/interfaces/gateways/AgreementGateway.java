package com.patterns.common.interfaces.gateways;

import com.patterns.domain.entity.Agreement;

import java.util.Optional;

public interface AgreementGateway {
    Optional<Agreement> getById(String id);

    Agreement save(Agreement agreement);

    Agreement update(Agreement agreement);

    boolean existsById(String id);
}