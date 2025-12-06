package com.patterns.domain.usecase;

import com.patterns.common.interfaces.gateways.InstallmentGateway;
import com.patterns.common.interfaces.usecases.CreateInstallmentUseCase;
import com.patterns.domain.entity.Installment;

import java.util.ArrayList;
import java.util.List;

public class CreateInstallmentUseCaseImpl implements CreateInstallmentUseCase {

    @Override
    public Installment create(Installment installment, InstallmentGateway gateway) {
        Integer lastPos = getLastInstallmentNumber(installment.getAgreementId(), gateway);

        installment.setNumber(lastPos + 1);

        return gateway.save(installment);
    }

    @Override
    public List<Installment> batchCreate(List<Installment> installments, InstallmentGateway gateway) {
        Integer lastPos = getLastInstallmentNumber(installments.get(0).getAgreementId(), gateway);

        final List<Installment> createdInstallments = new ArrayList<Installment>();

        for (Installment installment : installments) {
            installment.setNumber(lastPos + 1);

            final Installment createdInstallment = gateway.save(installment);
            createdInstallments.add(createdInstallment);

            lastPos++;
        }

        return createdInstallments;
    }

    private Integer getLastInstallmentNumber(String agreementId, InstallmentGateway gateway) {
        final List<Installment> existantInstallments = gateway.findAllByAgreementId(agreementId);

        if (existantInstallments.isEmpty()) {
            return 0;
        }

        return existantInstallments.size();
    }
}
