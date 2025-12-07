package com.patterns.common.interfaces.usecases;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.domain.entity.Agreement;

public interface GetAgreementUseCase {
    Agreement getAgreement(String agreementId) throws EntityNotFoundException;
}
