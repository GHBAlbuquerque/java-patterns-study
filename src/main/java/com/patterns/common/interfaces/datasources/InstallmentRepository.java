package com.patterns.common.interfaces.datasources;

import com.patterns.external.database.id.InstallmentId;
import com.patterns.external.database.orm.InstallmentORM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstallmentRepository  extends JpaRepository<InstallmentORM, InstallmentId> {

    List<InstallmentORM> findByIdAgreementId(String agreementId);
}
