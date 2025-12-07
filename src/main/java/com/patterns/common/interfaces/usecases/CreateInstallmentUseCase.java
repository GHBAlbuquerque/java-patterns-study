package com.patterns.common.interfaces.usecases;

import com.patterns.domain.entity.Installment;

import java.util.List;

public interface CreateInstallmentUseCase {

    Installment create(Installment installment);

    List<Installment> batchCreate(List<Installment> installments);
}
