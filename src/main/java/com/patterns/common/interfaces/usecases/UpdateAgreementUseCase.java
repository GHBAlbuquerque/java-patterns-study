package com.patterns.common.interfaces.usecases;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.domain.entity.Agreement;

public interface UpdateAgreementUseCase {
    Agreement updateAgreement(String agreementId, Agreement agreement) throws EntityNotFoundException;
}
