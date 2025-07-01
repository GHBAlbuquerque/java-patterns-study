package com.patterns.common.interfaces.usecases;

import com.patterns.domain.entity.Agreement;
import com.patterns.domain.enums.EntityEnum;

import java.util.Set;

public interface GetAgreementByIdUseCase {

    Agreement getAgreementById(final String id,
                               final Set<EntityEnum> entityEnumSet);
}
