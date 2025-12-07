package com.patterns.common.interfaces.usecases;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.AgreementGateway;
import com.patterns.domain.entity.Agreement;

public interface UpdateAgreementUseCase {
    Agreement updateAgreement(String agreementId, Agreement agreement, AgreementGateway agreementGateway) throws EntityNotFoundException;
}
