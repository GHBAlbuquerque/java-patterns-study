package com.patterns.application.beans;

import com.patterns.domain.usecase.CreateInvoiceUseCase;
import com.patterns.domain.usecase.GetInvoiceUseCase;
import com.patterns.domain.usecase.impl.CreateInvoiceUseCaseImpl;
import com.patterns.domain.usecase.impl.GetInvoiceUseCaseImpl;
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
    public CreateInvoiceUseCase invoiceCreationUseCase() {
        return new CreateInvoiceUseCaseImpl();
    }

    @Bean
    public GetInvoiceUseCase getInvoiceUseCase() {
        return new GetInvoiceUseCaseImpl();
    }
}
