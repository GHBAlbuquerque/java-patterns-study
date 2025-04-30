package com.patterns.common.mapper;

import com.patterns.common.dto.response.GetPaymentDTO;
import com.patterns.domain.entity.Payment;
import com.patterns.domain.enums.PaymentMethodEnum;
import com.patterns.external.database.orm.PaymentORM;

import java.util.Objects;

public class PaymentMapper {

    public static GetPaymentDTO fromDomainToGetDTO(Payment payment) {

        return new GetPaymentDTO(payment.getId(),
                payment.getInvoiceId(),
                payment.getAmount(),
                payment.getDate(),
                payment.getPaymentMethod().toString(),
                payment.getStatus().toString());
    }

    public static Payment fromDTOtoDomain(GetPaymentDTO dto) {

        return new Payment(dto.getId(),
                dto.getInvoiceId(),
                dto.getAmount(),
                dto.getDate(),
                dto.getPaymentMethod(),
                dto.getStatus());
    }

    public static PaymentORM fromDomainToORM(Payment Payment) {

        return new PaymentORM(Payment.getId(),
                Payment.getBarcode(),
                Payment.getAmount(),
                Payment.getDueDate(),
                Payment.getIssueDate(),
                Payment.getIssuer(),
                Payment.getStatus());
    }

    public static Payment fromORMtoDomain(PaymentORM orm) {
        if (Objects.isNull(orm)) {
            return null;
        }

        return new Payment(orm.getId(),
                orm.getBarcode(),
                orm.getAmount(),
                orm.getDueDate(),
                orm.getIssueDate(),
                orm.getIssuer(),
                orm.getStatus());
    }
}
