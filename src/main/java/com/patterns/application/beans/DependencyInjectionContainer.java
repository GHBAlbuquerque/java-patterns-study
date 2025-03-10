package com.patterns.application.beans;

import com.patterns.domain.usecase.CreateBillUseCase;
import com.patterns.domain.usecase.GetBillUseCase;
import com.patterns.domain.usecase.impl.CreateBillUseCaseImpl;
import com.patterns.domain.usecase.impl.GetBillUseCaseImpl;
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
    public CreateBillUseCase billCreationUseCase() {
        return new CreateBillUseCaseImpl();
    }

    @Bean
    public GetBillUseCase getBillUseCase() {
        return new GetBillUseCaseImpl();
    }
}
