package com.patterns.application.mapper;

import com.patterns.application.entrypoint.dto.CreatePaymentDTO;
import com.patterns.application.entrypoint.dto.GetPaymentDTO;
import com.patterns.domain.entity.Payment;
import com.patterns.repository.payment.orm.PaymentORM;

public class PaymentMapper {

    public GetPaymentDTO fromDomainToDTO(Payment payment) {

        return new GetPaymentDTO(payment.getId(),
                payment.getBarcode(),
                payment.getAmount(),
                payment.getDueDate(),
                payment.getIssueDate(),
                payment.getIssuer());
    }

    public Payment fromDTOtoDomain(GetPaymentDTO dto) {

        return new Payment(dto.id(),
                dto.barcode(),
                dto.amount(),
                dto.dueDate(),
                dto.issueDate(),
                dto.issuer());
    }

    public Payment fromCreationDTOtoDomain(CreatePaymentDTO dto) {

        return new Payment(dto.amount(),
                dto.dueDate(),
                dto.issueDate(),
                dto.issuer());
    }

    public PaymentORM fromDomainToORM(Payment payment) {

        return new PaymentORM(payment.getId(),
                payment.getBarcode(),
                payment.getAmount(),
                payment.getDueDate(),
                payment.getIssueDate(),
                payment.getIssuer());
    }

    public Payment fromORMtoDomain(PaymentORM orm) {

        return new Payment(orm.id(),
                orm.barcode(),
                orm.amount(),
                orm.dueDate(),
                orm.issueDate(),
                orm.issuer());
    }
}
