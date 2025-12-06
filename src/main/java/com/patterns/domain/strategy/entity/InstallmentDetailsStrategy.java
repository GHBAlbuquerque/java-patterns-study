package com.patterns.domain.strategy.entity;

import com.patterns.common.interfaces.gateways.InstallmentGateway;
import com.patterns.domain.entity.Agreement;
import com.patterns.domain.entity.Installment;
import com.patterns.domain.enums.EntityEnum;
import com.patterns.common.interfaces.usecases.GetInstallmentUseCase;

import java.util.List;

public class InstallmentDetailsStrategy extends Middleware {

    private final GetInstallmentUseCase getInstallmentUseCase;
    private final InstallmentGateway installmentGateway;

    public InstallmentDetailsStrategy(GetInstallmentUseCase getInstallmentUseCase, InstallmentGateway installmentGateway) {
        this.getInstallmentUseCase = getInstallmentUseCase;
        this.installmentGateway = installmentGateway;
    }

    @Override
    protected EntityEnum getEntityEnum() {
        return EntityEnum.INSTALLMENT;
    }

    @Override
    public void handle(Agreement.Builder builder, String agreementId) {
        List<Installment> installments = getInstallmentUseCase.getInstallments(agreementId, installmentGateway);
        builder.installments(installments);

        if (getNext().isPresent()) {
            getNext().get().handle(builder, agreementId);
        }
    }
}
