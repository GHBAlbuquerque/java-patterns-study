package com.patterns.common.beans;

import com.patterns.common.interfaces.gateways.AgreementGateway;
import com.patterns.common.interfaces.gateways.InstallmentGateway;
import com.patterns.common.interfaces.gateways.InvoiceEventGateway;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.GetAgreementUseCase;
import com.patterns.common.interfaces.usecases.GetInstallmentUseCase;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.domain.strategy.entity.AgreementDetailsStrategy;
import com.patterns.domain.strategy.entity.InstallmentDetailsStrategy;
import com.patterns.domain.strategy.entity.InvoiceDetailsStrategy;
import com.patterns.domain.strategy.event.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StrategyBeanDeclaration {

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

    @Bean
    public AgreementDetailsStrategy agreementDetailsStrategy(GetAgreementUseCase getAgreementUseCase){
        return new AgreementDetailsStrategy(getAgreementUseCase);
    }

    @Bean
    public InvoiceDetailsStrategy invoiceDetailsStrategy(GetInvoiceUseCase getInvoiceUseCase){
        return new InvoiceDetailsStrategy(getInvoiceUseCase);
    }

    @Bean
    public InstallmentDetailsStrategy installmentDetailsStrategy(GetInstallmentUseCase getInstallmentUseCase){
        return new InstallmentDetailsStrategy(getInstallmentUseCase);
    }
}
