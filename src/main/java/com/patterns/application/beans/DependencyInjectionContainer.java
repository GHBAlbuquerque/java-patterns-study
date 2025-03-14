package com.patterns.application.beans;

import com.patterns.domain.usecase.CreatePaymentUseCase;
import com.patterns.domain.usecase.GetPaymentUseCase;
import com.patterns.domain.usecase.impl.CreatePaymentUseCaseImpl;
import com.patterns.domain.usecase.impl.GetPaymentUseCaseImpl;
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
    public CreatePaymentUseCase paymentCreationUseCase() {
        return new CreatePaymentUseCaseImpl();
    }

    @Bean
    public GetPaymentUseCase getPaymentUseCase() {
        return new GetPaymentUseCaseImpl();
    }
}
