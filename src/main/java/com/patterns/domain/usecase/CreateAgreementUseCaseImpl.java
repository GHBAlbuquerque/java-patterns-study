package com.patterns.domain.usecase;

import com.patterns.common.interfaces.gateways.AgreementGateway;
import com.patterns.common.interfaces.usecases.CreateAgreementUseCase;
import com.patterns.domain.entity.Agreement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAgreementUseCaseImpl implements CreateAgreementUseCase {

    private final Logger log = LoggerFactory.getLogger(CreateAgreementUseCase.class);

    @Override
    public Agreement createAgreement(Agreement agreement, AgreementGateway agreementGateway) {
        if (agreement == null) {
            log.error("Attempted to create an agreement with null data.");
            throw new IllegalArgumentException("Invalid agreement data");
        }

            return agreementGateway.save(agreement);
        }
    }
