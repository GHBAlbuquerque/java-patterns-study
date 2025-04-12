package com.patterns.common.mapper;

import com.patterns.common.dto.request.CreateInvoiceDTO;
import com.patterns.common.dto.response.GetInvoiceDTO;
import com.patterns.domain.entity.Invoice;
import com.patterns.domain.enums.StatusEnum;
import com.patterns.external.orm.InvoiceORM;

public class InvoiceMapper {

    public static GetInvoiceDTO fromDomainToGetDTO(Invoice invoice) {

        return new GetInvoiceDTO(invoice.getId(),
                invoice.getBarcode(),
                invoice.getAmount(),
                invoice.getDueDate(),
                invoice.getIssueDate(),
                invoice.getIssuer(),
                invoice.getStatus());
    }

    public static Invoice fromDTOtoDomain(GetInvoiceDTO dto) {

        return new Invoice(dto.id(),
                dto.barcode(),
                dto.amount(),
                dto.dueDate(),
                dto.issueDate(),
                dto.issuer(),
                dto.status());
    }

    public static Invoice fromCreateDTOtoDomain(CreateInvoiceDTO dto) {

        return new Invoice(dto.amount(),
                dto.dueDate(),
                dto.issueDate(),
                dto.issuer(),
                StatusEnum.ACTIVE);
    }

    public static InvoiceORM fromDomainToORM(Invoice invoice) {

        return new InvoiceORM(invoice.getId(),
                invoice.getBarcode(),
                invoice.getAmount(),
                invoice.getDueDate(),
                invoice.getIssueDate(),
                invoice.getIssuer(),
                invoice.getStatus());
    }

    public static Invoice fromORMtoDomain(InvoiceORM orm) {

        return new Invoice(orm.getId(),
                orm.getBarcode(),
                orm.getAmount(),
                orm.getDueDate(),
                orm.getIssueDate(),
                orm.getIssuer(),
                orm.getStatus());
    }
}
