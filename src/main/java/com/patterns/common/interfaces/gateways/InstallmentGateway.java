package com.patterns.common.interfaces.gateways;

import com.patterns.domain.entity.Installment;
import com.patterns.external.database.id.InstallmentId;

import java.util.List;
import java.util.Optional;

public interface InstallmentGateway {
    Optional<Installment> getById(InstallmentId id);

    Installment save(Installment installment);

    List<Installment> findAllByAgreementId(String agreementId);
}