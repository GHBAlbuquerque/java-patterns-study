package com.patterns.repository.payment.repository;

import com.patterns.repository.payment.orm.PaymentORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentORM, String> {
}
