package com.patterns.common.interfaces.usecases;

import com.patterns.common.interfaces.gateways.InstallmentGateway;
import com.patterns.domain.entity.Installment;

import java.util.List;

public interface CreateInstallmentUseCase {

    Installment create(Installment installment, InstallmentGateway gateway);

    List<Installment> batchCreate(List<Installment> installments, InstallmentGateway gateway);
}
