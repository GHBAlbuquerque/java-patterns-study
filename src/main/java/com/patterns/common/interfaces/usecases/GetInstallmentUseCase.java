package com.patterns.common.interfaces.usecases;

import com.patterns.domain.entity.Installment;

import java.util.List;

public interface GetInstallmentUseCase {
    List<Installment> getInstallments(String agreementId);
}
