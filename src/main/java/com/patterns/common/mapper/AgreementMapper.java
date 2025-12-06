package com.patterns.common.mapper;

import com.patterns.communication.dto.request.CreateAgreementDTO;
import com.patterns.communication.dto.response.GetAgreementByIdDTO;
import com.patterns.domain.entity.Agreement;
import com.patterns.external.database.orm.AgreementORM;

import java.util.ArrayList;
import java.util.Objects;

public class AgreementMapper {

    public static GetAgreementByIdDTO fromDomainToGetDTO(final Agreement agreement) {
        return new GetAgreementByIdDTO(
                agreement.getId(),
                agreement.getInstallments(),
                agreement.getInvoices(),
                agreement.getTotalAmount()
        );
    }

    public static Agreement fromDTOtoDomain(final CreateAgreementDTO dto) {
        return new Agreement(
                dto.totalAmount()
        );
    }

    public static AgreementORM fromDomainToORM(final Agreement agreement) {

        return new AgreementORM(
                agreement.getId(),
                agreement.getTotalAmount()
        );
    }

    public static Agreement fromORMtoDomain(final AgreementORM orm) {
        if (Objects.isNull(orm)) {
            return null;
        }

        return new Agreement(
                orm.getId(),
                new ArrayList<>(),
                new ArrayList<>(),
                orm.getTotalAmount()
        );
    }
}