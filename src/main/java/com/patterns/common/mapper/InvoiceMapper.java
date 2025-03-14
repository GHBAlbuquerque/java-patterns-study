package com.patterns.common.mapper;

import com.patterns.common.dto.CreateInvoiceDTO;
import com.patterns.common.dto.GetInvoiceDTO;
import com.patterns.domain.entity.Invoice;
import com.patterns.external.orm.InvoiceORM;

public class InvoiceMapper {

    public GetInvoiceDTO fromDomainToDTO(Invoice invoice) {

        return new GetInvoiceDTO(invoice.getId(),
                invoice.getBarcode(),
                invoice.getAmount(),
                invoice.getDueDate(),
                invoice.getIssueDate(),
                invoice.getIssuer());
    }

    public Invoice fromDTOtoDomain(GetInvoiceDTO dto) {

        return new Invoice(dto.id(),
                dto.barcode(),
                dto.amount(),
                dto.dueDate(),
                dto.issueDate(),
                dto.issuer());
    }

    public Invoice fromCreationDTOtoDomain(CreateInvoiceDTO dto) {

        return new Invoice(dto.amount(),
                dto.dueDate(),
                dto.issueDate(),
                dto.issuer());
    }

    public InvoiceORM fromDomainToORM(Invoice invoice) {

        return new InvoiceORM(invoice.getId(),
                invoice.getBarcode(),
                invoice.getAmount(),
                invoice.getDueDate(),
                invoice.getIssueDate(),
                invoice.getIssuer());
    }

    public Invoice fromORMtoDomain(InvoiceORM orm) {

        return new Invoice(orm.id(),
                orm.barcode(),
                orm.amount(),
                orm.dueDate(),
                orm.issueDate(),
                orm.issuer());
    }
}
