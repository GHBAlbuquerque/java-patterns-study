package com.patterns.common.interfaces.usecases;

import com.patterns.domain.entity.Agreement;

public interface CreateAgreementUseCase {
    Agreement createAgreement(Agreement agreement);
}
