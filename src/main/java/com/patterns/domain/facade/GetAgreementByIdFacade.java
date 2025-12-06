package com.patterns.domain.facade;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.strategy.EntityStrategy;
import com.patterns.domain.entity.Agreement;
import com.patterns.domain.enums.EntityEnum;
import com.patterns.domain.strategy.entity.Middleware;

import java.util.List;
import java.util.Set;

public class GetAgreementByIdFacade {

    private final List<Middleware> entityStrategies;

    public GetAgreementByIdFacade(List<Middleware> entityStrategies) {
        this.entityStrategies = entityStrategies;
    }

    public Agreement getAgreementById(
            final String id,
            final Set<EntityEnum> entityEnumSet
    ) throws EntityNotFoundException {
        final Agreement.Builder builder = new Agreement.Builder();

        final EntityStrategy middleware = Middleware.link(
                entityEnumSet,
                entityStrategies
        );

        if (middleware != null) {
            middleware.handle(builder, id);
        }

        return builder.build();
    }
}
