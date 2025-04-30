package com.patterns.communication.gateway;

import com.patterns.common.interfaces.datasources.PaymentRepository;
import com.patterns.common.interfaces.gateways.PaymentGateway;
import com.patterns.common.mapper.InvoiceMapper;
import com.patterns.domain.entity.Payment;
import com.patterns.external.database.id.PaymentId;

import java.util.Optional;

public class PaymentGatewayImpl implements PaymentGateway {

    private final PaymentRepository repository;

    public PaymentGatewayImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Payment> getPaymentById(PaymentId paymentId) {
        var optional = repository.findById(paymentId);

        return optional.map(InvoiceMapper::fromORMtoDomain);
    }

    @Override
    public Payment getPaymentMethodById(PaymentId paymentId) {
        var optional = repository.findPaymentMethodByIdAndInvoiceId(paymentId.getId(), paymentId.getInvoiceId());

        return optional.map(InvoiceMapper::fromORMtoDomain).orElse(null);
    }
}
