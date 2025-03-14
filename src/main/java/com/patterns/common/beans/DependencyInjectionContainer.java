package com.patterns.common.beans;

import com.patterns.common.interfaces.datasources.InvoiceRepository;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.CreateInvoiceUseCase;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.communication.gateway.InvoiceGatewayImpl;
import com.patterns.domain.usecase.CreateInvoiceUseCaseImpl;
import com.patterns.domain.usecase.GetInvoiceUseCaseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectionContainer {

    @Bean
    public Logger logger() {
        return LogManager.getLogger();
    }

    @Bean
    public InvoiceGateway invoiceGateway(InvoiceRepository invoiceRepository) {
        return new InvoiceGatewayImpl(invoiceRepository);
    }

    @Bean
    public CreateInvoiceUseCase createInvoiceUseCase() {
        return new CreateInvoiceUseCaseImpl();
    }

    @Bean
    public GetInvoiceUseCase getInvoiceUseCase() {
        return new GetInvoiceUseCaseImpl();
    }
}
