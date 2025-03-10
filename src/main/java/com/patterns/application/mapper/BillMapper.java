package com.patterns.application.mapper;

import com.patterns.application.entrypoint.dto.BillDTO;
import com.patterns.domain.entity.Bill;
import com.patterns.repository.bill.orm.BillORM;

public class BillMapper {

    public BillDTO fromDomainToDTO(Bill bill) {

        return new BillDTO(bill.id(),
                bill.barcode(),
                bill.amount(),
                bill.dueDate(),
                bill.issueDate(),
                bill.issuer());
    }

    public Bill fromDTOtoDomain(BillDTO dto) {

        return new Bill(dto.id(),
                dto.barcode(),
                dto.amount(),
                dto.dueDate(),
                dto.issueDate(),
                dto.issuer());
    }

    public BillORM fromDomainToORM(Bill bill) {

        return new BillORM(bill.id(),
                bill.barcode(),
                bill.amount(),
                bill.dueDate(),
                bill.issueDate(),
                bill.issuer());
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
