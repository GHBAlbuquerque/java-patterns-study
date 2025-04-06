package com.patterns.common.beans;

import com.patterns.common.interfaces.datasources.InvoiceRepository;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.communication.gateway.InvoiceGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayBeanDeclaration {

    @Bean
    public InvoiceGateway invoiceGateway(InvoiceRepository invoiceRepository) {
        return new InvoiceGatewayImpl(invoiceRepository);
    }
}
