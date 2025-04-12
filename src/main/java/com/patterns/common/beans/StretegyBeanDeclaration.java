package com.patterns.common.beans;

import com.patterns.common.interfaces.gateways.InvoiceEventGateway;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.domain.strategy.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StretegyBeanDeclaration {

    @Bean
    public PaymentCancelledEventStrategyImpl paymentCancelledEventStrategy(InvoiceGateway invoiceGateway, InvoiceEventGateway invoiceEventGateway) {
        return new PaymentCancelledEventStrategyImpl(invoiceGateway, invoiceEventGateway);
    }

    @Bean
    public PaymentCreatedEventStrategyImpl paymentCreatedEventStrategy(InvoiceGateway invoiceGateway, InvoiceEventGateway invoiceEventGateway){
        return new PaymentCreatedEventStrategyImpl(invoiceGateway, invoiceEventGateway);
    }

    @Bean
    public PaymentReceivedEventStrategyImpl paymentReceivedEventStrategy(InvoiceGateway invoiceGateway, InvoiceEventGateway invoiceEventGateway){
        return new PaymentReceivedEventStrategyImpl(invoiceGateway, invoiceEventGateway);
    }

    @Bean
    public PaymentInconsistentEventStrategyImpl paymentInconsistentEventStrategy(InvoiceGateway invoiceGateway, InvoiceEventGateway invoiceEventGateway){
        return new PaymentInconsistentEventStrategyImpl(invoiceGateway, invoiceEventGateway);
    }

    @Bean
    public PaymentPendingEventStrategyImpl paymentPendingStrategy(InvoiceGateway invoiceGateway, InvoiceEventGateway invoiceEventGateway){
        return new PaymentPendingEventStrategyImpl(invoiceGateway, invoiceEventGateway);
    }

    @Bean
    public PaymentSuspendedEventStrategyImpl paymentSuspendedEventStrategy(InvoiceGateway invoiceGateway, InvoiceEventGateway invoiceEventGateway){
        return new PaymentSuspendedEventStrategyImpl(invoiceGateway, invoiceEventGateway);
    }
}
