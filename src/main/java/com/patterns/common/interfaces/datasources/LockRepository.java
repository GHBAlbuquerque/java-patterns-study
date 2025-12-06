package com.patterns.common.interfaces.datasources;

import com.patterns.external.database.orm.LockORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockRepository extends JpaRepository<LockORM, String> {
}
