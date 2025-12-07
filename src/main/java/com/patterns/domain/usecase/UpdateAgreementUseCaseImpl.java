package com.patterns.domain.usecase;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.AgreementGateway;
import com.patterns.common.interfaces.usecases.UpdateAgreementUseCase;
import com.patterns.common.mapper.AgreementMapper;
import com.patterns.domain.entity.Agreement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.patterns.domain.validator.ValidationMessageEnum.MSAGR0001;

@Service
public class UpdateAgreementUseCaseImpl implements UpdateAgreementUseCase {

    private final Logger log = LoggerFactory.getLogger(UpdateAgreementUseCaseImpl.class);
    private final AgreementGateway agreementGateway;

    public UpdateAgreementUseCaseImpl(AgreementGateway agreementGateway) {
        this.agreementGateway = agreementGateway;
    }

    @Override
    public Agreement updateAgreement(String agreementId, Agreement agreement)
        throws EntityNotFoundException {
        log.info("Attempting to update agreement with ID: {}", agreementId);

        Agreement existingAgreement = agreementGateway.getById(agreementId)
            .orElseThrow(() -> {
                log.error("Agreement with ID {} not found for update.", agreementId);
                return new EntityNotFoundException(MSAGR0001.getCode(), MSAGR0001.getLogMessage());
            });

        AgreementMapper.update(existingAgreement, agreement);

        Agreement updatedAgreement = agreementGateway.update(agreement);
        log.info("Agreement with ID {} updated successfully.", agreementId);
        return updatedAgreement;
    }
}
