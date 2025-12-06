package com.patterns.domain.usecase;

import com.patterns.common.interfaces.gateways.InstallmentGateway;
import com.patterns.common.interfaces.usecases.GetInstallmentUseCase;
import com.patterns.domain.entity.Installment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GetInstallmentUseCaseImpl implements GetInstallmentUseCase {

    private final Logger log = LogManager.getLogger(GetInstallmentUseCaseImpl.class);

    @Override
    public List<Installment> getInstallments(final String agreementId, InstallmentGateway installmentGateway) {
        log.info("Retrieving installments for agreement id: {}", agreementId);
        return installmentGateway.findAllByAgreementId(agreementId);
    }
}
