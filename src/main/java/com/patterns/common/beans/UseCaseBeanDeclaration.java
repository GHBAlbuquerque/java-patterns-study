package com.patterns.common.beans;

import com.patterns.common.interfaces.usecases.BatchValidateInvoiceUseCase;
import com.patterns.common.interfaces.usecases.CreateInvoiceUseCase;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.domain.usecase.BatchValidateInvoiceUseCaseImpl;
import com.patterns.domain.usecase.CreateInvoiceUseCaseImpl;
import com.patterns.domain.usecase.GetInvoiceUseCaseImpl;
import com.patterns.domain.validator.barcode.BarcodeValidator;
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

    @Bean
    public BatchValidateInvoiceUseCase batchValidateInvoiceUseCase() {
        return new BatchValidateInvoiceUseCaseImpl(new BarcodeValidator());
    }
}
