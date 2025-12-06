package com.patterns.domain.strategy.entity;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.AgreementGateway;
import com.patterns.common.interfaces.usecases.GetAgreementUseCase;
import com.patterns.domain.entity.Agreement;
import com.patterns.domain.enums.EntityEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AgreementDetailsStrategy extends Middleware {

    private final Logger log = LogManager.getLogger(AgreementDetailsStrategy.class);
    private final GetAgreementUseCase getAgreementUseCase;
    private final AgreementGateway agreementGateway;

    public AgreementDetailsStrategy(GetAgreementUseCase getAgreementUseCase, AgreementGateway agreementGateway) {
        this.getAgreementUseCase = getAgreementUseCase;
        this.agreementGateway = agreementGateway;
    }

    @Override
    protected EntityEnum getEntityEnum() {
        return EntityEnum.AGREEMENT;
    }

    @Override
    public void handle(Agreement.Builder builder, String agreementId) throws EntityNotFoundException {
        Agreement agreement = getAgreementUseCase.getAgreement(agreementId, agreementGateway);
        builder.id(agreement.getId());
        builder.totalAmount(agreement.getTotalAmount());

        if (getNext().isPresent()) {
            getNext().get().handle(builder, agreementId);
        }
    }
}
