package com.patterns.common.interfaces.gateways;

import com.patterns.domain.entity.Payment;
import com.patterns.external.database.id.PaymentId;

import java.util.Optional;

public interface PaymentGateway {

    Optional<Payment> getPaymentById(PaymentId paymentId);

    Payment getPaymentMethodById(PaymentId paymentId);
}
