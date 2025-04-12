package com.patterns.common.beans;

import com.patterns.common.interfaces.external.MessageSender;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.domain.usecase.eventstrategy.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StretegyBeanDeclaration {

    @Bean
    public PaymentCancelledEventUpdateUseCaseUseCase paymentCancelledEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway, MessageSender messageSender) {
        return new PaymentCancelledEventUpdateUseCaseUseCase(invoiceGateway, messageSender);
    }

    @Bean
    public PaymentCreatedEventUpdateUseCaseUseCase paymentCreatedEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway, MessageSender messageSender) {
        return new PaymentCreatedEventUpdateUseCaseUseCase(invoiceGateway, messageSender);
    }

    @Bean
    public PaymentReceivedEventUpdateUseCaseUseCase paymentDoneEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway, MessageSender messageSender) {
        return new PaymentReceivedEventUpdateUseCaseUseCase(invoiceGateway, messageSender);
    }

    @Bean
    public PaymentInconsistentEventUpdateUseCaseUseCase paymentInconsistentEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway, MessageSender messageSender) {
        return new PaymentInconsistentEventUpdateUseCaseUseCase(invoiceGateway, messageSender);
    }

    @Bean
    public PaymentPendingEventUpdateUseCaseUseCase paymentPendingEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway, MessageSender messageSender) {
        return new PaymentPendingEventUpdateUseCaseUseCase(invoiceGateway, messageSender);
    }

    @Bean
    public PaymentSuspendedEventUpdateUseCaseUseCase paymentSuspendedEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway, MessageSender messageSender) {
        return new PaymentSuspendedEventUpdateUseCaseUseCase(invoiceGateway, messageSender);
    }
}
