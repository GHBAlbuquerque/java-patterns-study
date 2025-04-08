package com.patterns.common.beans;

import com.patterns.common.interfaces.datasources.InvoiceRepository;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.gateways.PaymentEventGateway;
import com.patterns.communication.gateway.InvoiceGatewayImpl;
import com.patterns.communication.gateway.PaymentEventGatewayImpl;
import com.patterns.domain.usecase.eventstrategy.EventUseCaseAbstract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GatewayBeanDeclaration {

    @Bean
    public InvoiceGateway invoiceGateway(InvoiceRepository invoiceRepository) {
        return new InvoiceGatewayImpl(invoiceRepository);
    }

    @Bean
    public PaymentEventGateway messagingGateway(List<EventUseCaseAbstract> eventUseCases) {
        return new PaymentEventGatewayImpl(eventUseCases);
    }
}
