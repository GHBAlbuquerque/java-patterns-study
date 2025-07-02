package com.patterns.common.interfaces.datasources;

import com.patterns.external.database.orm.AgreementORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository  extends JpaRepository<AgreementORM, String> {
}
