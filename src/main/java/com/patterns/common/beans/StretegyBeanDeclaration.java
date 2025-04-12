package com.patterns.common.beans;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.domain.strategy.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StretegyBeanDeclaration {

    @Bean
    public PaymentCancelledEventStrategyImpl paymentCancelledEventStrategy(InvoiceGateway invoiceGateway) {
        return new PaymentCancelledEventStrategyImpl(invoiceGateway);
    }

    @Bean
    public PaymentCreatedEventStrategyImpl paymentCreatedEventStrategy(InvoiceGateway invoiceGateway) {
        return new PaymentCreatedEventStrategyImpl(invoiceGateway);
    }

    @Bean
    public PaymentReceivedEventStrategyImpl paymentReceivedEventStrategy(InvoiceGateway invoiceGateway) {
        return new PaymentReceivedEventStrategyImpl(invoiceGateway);
    }

    @Bean
    public PaymentInconsistentEventStrategyImpl paymentInconsistentEventStrategy(InvoiceGateway invoiceGateway) {
        return new PaymentInconsistentEventStrategyImpl(invoiceGateway);
    }

    @Bean
    public PaymentPendingEventStrategyImpl paymentPendingStrategy(InvoiceGateway invoiceGateway) {
        return new PaymentPendingEventStrategyImpl(invoiceGateway);
    }

    @Bean
    public PaymentSuspendedEventStrategyImpl paymentSuspendedEventStrategy(InvoiceGateway invoiceGateway) {
        return new PaymentSuspendedEventStrategyImpl(invoiceGateway);
    }
}
