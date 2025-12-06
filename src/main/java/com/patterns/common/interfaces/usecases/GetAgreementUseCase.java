package com.patterns.common.interfaces.usecases;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.AgreementGateway;
import com.patterns.domain.entity.Agreement;

public interface GetAgreementUseCase {
    Agreement getAgreement(String agreementId, AgreementGateway agreementGateway) throws EntityNotFoundException;
}
