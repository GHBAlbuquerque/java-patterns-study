package com.patterns.repository.bill.repository;

import com.patterns.repository.bill.orm.BillORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<BillORM, String> {
}
