package com.patterns.common.interfaces.gateways;

import com.patterns.domain.entity.Installment;
import com.patterns.external.database.id.InstallmentId;

import java.util.List;
import java.util.Optional;

public interface InstallmentGateway {
    Optional<Installment> getInstallmentById(InstallmentId id);

    Installment saveInstallment(Installment installment);

    List<Installment> findInstallmentsByAgreementId(String agreementId);
}