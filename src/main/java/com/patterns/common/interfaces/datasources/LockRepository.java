package com.patterns.common.interfaces.datasources;

import com.patterns.external.database.orm.LockORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LockRepository extends JpaRepository<LockORM, String> {
    Optional<LockORM> findByEntityId(String entityId);
}
