package com.patterns.common.interfaces.datasources;

import com.patterns.external.database.id.PaymentId;
import com.patterns.external.database.orm.PaymentORM;
import com.patterns.external.database.projections.PaymentMethodView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentORM, PaymentId> {

    PaymentMethodView findById(String id);

}
