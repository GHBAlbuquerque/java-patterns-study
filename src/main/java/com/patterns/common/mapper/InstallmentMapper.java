package com.patterns.common.mapper;

import com.patterns.common.dto.request.CreateInstallmentDTO;
import com.patterns.common.dto.response.GetInstallmentDTO;
import com.patterns.domain.entity.Installment;
import com.patterns.external.database.id.InstallmentId;
import com.patterns.external.database.orm.InstallmentORM;

import java.util.Objects;

public class InstallmentMapper {

    public static GetInstallmentDTO fromDomainToGetDTO(final Installment installment) {
        return new GetInstallmentDTO(
                installment.getAgreementId(),
                installment.getNumber(),
                installment.getDueDate(),
                installment.getPaymentDate(),
                installment.getAmount(),
                installment.getPaidAmount(),
                installment.getInterest(),
                installment.getStatus(),
                installment.getPaymentMethod()
        );
    }

    public static Installment fromDTOToDomain(CreateInstallmentDTO createInstallmentDTO){
        return new Installment(
                createInstallmentDTO.getAgreementId(),
                createInstallmentDTO.getDueDate(),
                createInstallmentDTO.getPaymentDate(),
                createInstallmentDTO.getAmount(),
                createInstallmentDTO.getPaidAmount(),
                createInstallmentDTO.getInterest(),
                createInstallmentDTO.getStatus(),
                createInstallmentDTO.getPaymentMethod()
        );
    }

    public static InstallmentORM fromDomainToORM(final Installment installment) {
        final InstallmentId installmentId = new InstallmentId(
                installment.getAgreementId(),
                installment.getNumber()
        );

        return new InstallmentORM(
                installmentId,
                installment.getDueDate(),
                installment.getPaymentDate(),
                installment.getAmount(),
                installment.getPaidAmount(),
                installment.getInterest(),
                installment.getStatus(),
                installment.getPaymentMethod()
        );
    }

    public static Installment fromORMtoDomain(final InstallmentORM orm) {
        if (Objects.isNull(orm)) {
            return null;
        }
        return new Installment(
                orm.getId().getAgreementId(),
                orm.getId().getNumber(),
                orm.getDueDate(),
                orm.getPaymentDate(),
                orm.getAmount(),
                orm.getPaidAmount(),
                orm.getInterest(),
                orm.getStatus(),
                orm.getPaymentMethod()
        );
    }
}