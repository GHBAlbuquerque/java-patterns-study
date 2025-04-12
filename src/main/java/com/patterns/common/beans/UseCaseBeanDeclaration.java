package com.patterns.common.beans;

import com.patterns.common.interfaces.usecases.CreateInvoiceUseCase;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.domain.usecase.CreateInvoiceUseCaseImpl;
import com.patterns.domain.usecase.GetInvoiceUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanDeclaration {

    @Bean
    public CreateInvoiceUseCase createInvoiceUseCase() {
        return new CreateInvoiceUseCaseImpl();
    }

    @Bean
    public GetInvoiceUseCase getInvoiceUseCase() {
        return new GetInvoiceUseCaseImpl();
    }
}
