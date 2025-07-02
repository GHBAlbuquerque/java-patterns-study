package com.patterns.common.interfaces.gateways;

import com.patterns.domain.entity.Agreement;

import java.util.Optional;

public interface AgreementGateway {
    Optional<Agreement> getAgreementById(String id);

    Agreement saveAgreement(Agreement agreement);
}