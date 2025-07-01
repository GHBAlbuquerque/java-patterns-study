package com.patterns.domain.strategy.entity;

import com.patterns.domain.entity.Agreement;
import com.patterns.domain.enums.EntityEnum;

public class InstallmentDetailsStrategy extends Middleware {

    @Override
    protected EntityEnum getEntityEnum() {
        return EntityEnum.INSTALLMENT;
    }

    @Override
    public void handle(Agreement.Builder builder, String acordoId) {
        // ---- TODO ----
    }
    
}
