package com.patterns.domain.usecase;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.AgreementGateway;
import com.patterns.common.interfaces.usecases.GetAgreementUseCase;
import com.patterns.domain.entity.Agreement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.patterns.domain.validator.ValidationMessageEnum.MSAGR0001;

public class GetAgreementUseCaseImpl implements GetAgreementUseCase {

    private final Logger log = LogManager.getLogger(GetAgreementUseCaseImpl.class);
    private final AgreementGateway agreementGateway;

    public GetAgreementUseCaseImpl(AgreementGateway agreementGateway) {
        this.agreementGateway = agreementGateway;
    }

    @Override
    public Agreement getAgreement(final String agreementId)
        throws EntityNotFoundException {
        log.info("Retrieving agreement by id: {}", agreementId);
        var result = agreementGateway.getById(agreementId);

        if (result.isEmpty()) {
            log.error(MSAGR0001.getLogMessage());
            throw new EntityNotFoundException(MSAGR0001.getCode(), MSAGR0001.getLogMessage());
        }

        return result.get();
    }
}
