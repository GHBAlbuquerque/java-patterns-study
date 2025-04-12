package com.patterns.common.beans;

import com.patterns.common.interfaces.datasources.InvoiceRepository;
import com.patterns.common.interfaces.external.MessageSender;
import com.patterns.common.interfaces.gateways.InvoiceEventGateway;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.gateways.PaymentEventGateway;
import com.patterns.communication.gateway.InvoiceEventGatewayImpl;
import com.patterns.communication.gateway.InvoiceGatewayImpl;
import com.patterns.communication.gateway.PaymentEventGatewayImpl;
import com.patterns.domain.strategy.EventStrategy;
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
    public InvoiceEventGateway invoiceEventGateway(MessageSender messageSender) {
        return new InvoiceEventGatewayImpl(messageSender);
    }

    @Bean
    public PaymentEventGateway paymentEventGateway(List<EventStrategy> eventStrategyList) {
        return new PaymentEventGatewayImpl(eventStrategyList);
    }
}
