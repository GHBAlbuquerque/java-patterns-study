package com.patterns.common.mapper;

import com.patterns.common.dto.request.CreateInvoiceDTO;
import com.patterns.common.dto.response.*;
import com.patterns.domain.entity.Invoice;
import com.patterns.domain.enums.StatusEnum;
import com.patterns.external.database.orm.InvoiceORM;
import com.patterns.external.database.projections.IssuerView;
import com.patterns.external.database.projections.StatusView;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Objects;

public class InvoiceMapper {

    public static GetInvoiceDTO fromDomainToGetDTO(final Invoice invoice) {

        return new GetInvoiceDTO(invoice.getId(),
                invoice.getBarcode(),
                invoice.getAmount(),
                invoice.getDueDate(),
                invoice.getIssueDate(),
                invoice.getIssuer(),
                invoice.getStatus());
    }

    public static Invoice fromDTOtoDomain(final GetInvoiceDTO dto) {

        return new Invoice(dto.id(),
                dto.barcode(),
                dto.amount(),
                dto.dueDate(),
                dto.issueDate(),
                dto.issuer(),
                dto.status());
    }

    public static Invoice fromCreateDTOtoDomain(final CreateInvoiceDTO dto) {

        return new Invoice(dto.amount(),
                dto.dueDate(),
                dto.issueDate(),
                dto.issuer(),
                StatusEnum.ACTIVE);
    }

    public static InvoiceORM fromDomainToORM(final Invoice invoice) {

        return new InvoiceORM(invoice.getId(),
                invoice.getBarcode(),
                invoice.getAmount(),
                invoice.getDueDate(),
                invoice.getIssueDate(),
                invoice.getIssuer(),
                invoice.getStatus());
    }

    public static Invoice fromORMtoDomain(final InvoiceORM orm) {
        if (Objects.isNull(orm)) {
            return null;
        }

        return new Invoice(orm.getId(),
                orm.getBarcode(),
                orm.getAmount(),
                orm.getDueDate(),
                orm.getIssueDate(),
                orm.getIssuer(),
                orm.getStatus());
    }

    public static GetInvoiceIssuerDTO fromIssuerViewToDTO(final IssuerView view) {
        return new GetInvoiceIssuerDTO(view.getId(), view.getIssuer());
    }

    public static GetInvoiceStatusDTO fromStatusViewToDTO(final StatusView view) {
        return new GetInvoiceStatusDTO(view.getId(), view.getStatus());
    }

    public static <E extends IResponse> PagedResponse<E> fromPageToPagedResponse(final Page<Invoice> page, final List<E> content) {
        return new PagedResponse<>(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                content);
    }
}
