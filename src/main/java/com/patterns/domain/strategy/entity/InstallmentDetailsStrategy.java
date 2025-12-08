package com.patterns.domain.strategy.entity;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.usecases.GetInstallmentUseCase;
import com.patterns.domain.entity.Agreement;
import com.patterns.domain.entity.Installment;
import com.patterns.domain.enums.EntityEnum;

import java.util.List;

public class InstallmentDetailsStrategy extends Middleware {

    private final GetInstallmentUseCase getInstallmentUseCase;

    public InstallmentDetailsStrategy(GetInstallmentUseCase getInstallmentUseCase) {
        this.getInstallmentUseCase = getInstallmentUseCase;
    }

    @Override
    protected EntityEnum getEntityEnum() {
        return EntityEnum.INSTALLMENT;
    }

    @Override
    public void handle(Agreement.Builder builder, String agreementId)
        throws EntityNotFoundException {
        List<Installment> installments = getInstallmentUseCase.getInstallments(agreementId);
        builder.installments(installments);

        if (getNext().isPresent()) {
            getNext().get().handle(builder, agreementId);
        }
    }
}
