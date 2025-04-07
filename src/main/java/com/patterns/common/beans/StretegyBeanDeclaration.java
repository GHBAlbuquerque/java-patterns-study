package com.patterns.common.beans;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.domain.usecase.eventstrategy.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StretegyBeanDeclaration {

    @Bean
    public PaymentCancelledEventUpdateUseCaseUseCase paymentCancelledEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway) {
        return new PaymentCancelledEventUpdateUseCaseUseCase(invoiceGateway);
    }

    @Bean
    public PaymentCreatedEventUpdateUseCaseUseCase paymentCreatedEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway) {
        return new PaymentCreatedEventUpdateUseCaseUseCase(invoiceGateway);
    }

    @Bean
    public PaymentDoneEventUpdateUseCaseUseCase paymentDoneEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway) {
        return new PaymentDoneEventUpdateUseCaseUseCase(invoiceGateway);
    }

    @Bean
    public PaymentInconsistentEventUpdateUseCaseUseCase paymentInconsistentEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway) {
        return new PaymentInconsistentEventUpdateUseCaseUseCase(invoiceGateway);
    }

    @Bean
    public PaymentPendingEventUpdateUseCaseUseCase paymentPendingEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway) {
        return new PaymentPendingEventUpdateUseCaseUseCase(invoiceGateway);
    }

    @Bean
    public PaymentSuspendedEventUpdateUseCaseUseCase paymentSuspendedEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway) {
        return new PaymentSuspendedEventUpdateUseCaseUseCase(invoiceGateway);
    }
}
