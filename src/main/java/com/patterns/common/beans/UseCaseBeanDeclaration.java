package com.patterns.common.beans;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.gateways.LockGateway;
import com.patterns.common.interfaces.usecases.*;
import com.patterns.domain.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanDeclaration {

    @Bean
    public CreateInvoiceUseCase createInvoiceUseCase() {
        return new CreateInvoiceUseCaseImpl();
    }

    @Bean
    public UpdateInvoiceUseCase updateInvoiceUseCase() {
        return new UpdateInvoiceUseCaseImpl();
    }

    @Bean
    public GetInvoiceUseCase getInvoiceUseCase() {
        return new GetInvoiceUseCaseImpl();
    }

    @Bean
    public BatchValidateInvoiceUseCase batchValidateInvoiceUseCase(InvoiceGateway invoiceGateway) {
        return new BatchValidateInvoiceUseCaseImpl(invoiceGateway);
    }

    @Bean
    public CreateAgreementUseCase createAgreementUseCase() {
        return new CreateAgreementUseCaseImpl();
    }

    @Bean
    public UpdateAgreementUseCase updateAgreementUseCase() {
        return new UpdateAgreementUseCaseImpl();
    }

    @Bean
    public CreateInstallmentUseCase createInstallmentUseCase() {
        return new CreateInstallmentUseCaseImpl();
    }

    @Bean
    public GetAgreementUseCase agreementUseCase() { return new GetAgreementUseCaseImpl();}

    @Bean
    public GetInstallmentUseCase getInstallmentUseCase() { return new GetInstallmentUseCaseImpl();}

    @Bean
    public AcquireLockUseCase acquireLockUseCase(LockGateway lockGateway) { return new AcquireLockUseCaseImpl(lockGateway);}

}
