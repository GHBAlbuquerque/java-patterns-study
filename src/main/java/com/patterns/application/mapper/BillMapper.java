package com.patterns.application.mapper;

import com.patterns.application.entrypoint.dto.CreateBillDTO;
import com.patterns.application.entrypoint.dto.GetBillDTO;
import com.patterns.domain.entity.Bill;
import com.patterns.repository.bill.orm.BillORM;

public class BillMapper {

    public GetBillDTO fromDomainToDTO(Bill bill) {

        return new GetBillDTO(bill.getId(),
                bill.getBarcode(),
                bill.getAmount(),
                bill.getDueDate(),
                bill.getIssueDate(),
                bill.getIssuer());
    }

    public Bill fromDTOtoDomain(GetBillDTO dto) {

        return new Bill(dto.id(),
                dto.barcode(),
                dto.amount(),
                dto.dueDate(),
                dto.issueDate(),
                dto.issuer());
    }

    public Bill fromCreationDTOtoDomain(CreateBillDTO dto) {

        return new Bill(dto.amount(),
                dto.dueDate(),
                dto.issueDate(),
                dto.issuer());
    }

    public BillORM fromDomainToORM(Bill bill) {

        return new BillORM(bill.getId(),
                bill.getBarcode(),
                bill.getAmount(),
                bill.getDueDate(),
                bill.getIssueDate(),
                bill.getIssuer());
    }

    public Bill fromORMtoDomain(BillORM orm) {

        return new Bill(orm.id(),
                orm.barcode(),
                orm.amount(),
                orm.dueDate(),
                orm.issueDate(),
                orm.issuer());
    }
}
