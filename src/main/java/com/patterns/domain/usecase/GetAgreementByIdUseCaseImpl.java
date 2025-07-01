package com.patterns.domain.usecase;

import com.patterns.common.interfaces.strategy.EntityStrategy;
import com.patterns.common.interfaces.usecases.GetAgreementByIdUseCase;
import com.patterns.domain.entity.Agreement;
import com.patterns.domain.enums.EntityEnum;
import com.patterns.domain.strategy.entity.Middleware;

import java.util.List;
import java.util.Set;

public class GetAgreementByIdUseCaseImpl implements GetAgreementByIdUseCase {

    private final List<Middleware> entityStrategies; // ---- TODO --- validate if works

    public GetAgreementByIdUseCaseImpl(List<Middleware> entityStrategies) {
        this.entityStrategies = entityStrategies;
    }

    @Override
    public Agreement getAgreementById(
            final String id,
            final Set<EntityEnum> entityEnumSet
    ) {
        final Agreement.Builder builder = new Agreement.Builder();

        final EntityStrategy middleware = Middleware.link(
                entityEnumSet,
                entityStrategies
        );

        middleware.handle(builder, id);

        return builder.build();
    }
}
