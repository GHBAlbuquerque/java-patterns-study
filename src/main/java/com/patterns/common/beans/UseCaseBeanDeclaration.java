package com.patterns.common.beans;

import com.patterns.common.interfaces.gateways.AgreementGateway;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.gateways.LockGateway;
import com.patterns.common.interfaces.usecases.AcquireLockUseCase;
import com.patterns.common.interfaces.usecases.BatchValidateInvoiceUseCase;
import com.patterns.common.interfaces.usecases.CreateAgreementUseCase;
import com.patterns.common.interfaces.usecases.CreateInstallmentUseCase;
import com.patterns.common.interfaces.usecases.CreateInvoiceUseCase;
import com.patterns.common.interfaces.usecases.GetAgreementUseCase;
import com.patterns.common.interfaces.usecases.GetInstallmentUseCase;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.common.interfaces.usecases.UpdateAgreementUseCase;
import com.patterns.common.interfaces.usecases.UpdateInvoiceUseCase;
import com.patterns.common.properties.PropertiesMapper;
import com.patterns.domain.usecase.AcquireLockUseCaseImpl;
import com.patterns.domain.usecase.BatchValidateInvoiceUseCaseImpl;
import com.patterns.domain.usecase.CreateAgreementUseCaseImpl;
import com.patterns.domain.usecase.CreateInstallmentUseCaseImpl;
import com.patterns.domain.usecase.CreateInvoiceUseCaseImpl;
import com.patterns.domain.usecase.GetAgreementUseCaseImpl;
import com.patterns.domain.usecase.GetInstallmentUseCaseImpl;
import com.patterns.domain.usecase.GetInvoiceUseCaseImpl;
import com.patterns.domain.usecase.UpdateAgreementUseCaseImpl;
import com.patterns.domain.usecase.UpdateInvoiceUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanDeclaration {

    @Bean
    public CreateInvoiceUseCase createInvoiceUseCase(InvoiceGateway invoiceGateway, PropertiesMapper propertiesMapper) {
        return new CreateInvoiceUseCaseImpl(invoiceGateway, propertiesMapper);
    }

    @Bean
    public UpdateInvoiceUseCase updateInvoiceUseCase(InvoiceGateway invoiceGateway) {
        return new UpdateInvoiceUseCaseImpl(invoiceGateway);
    }

    @Bean
    public GetInvoiceUseCase getInvoiceUseCase(InvoiceGateway invoiceGateway) {
        return new GetInvoiceUseCaseImpl(invoiceGateway);
    }

    @Bean
    public BatchValidateInvoiceUseCase batchValidateInvoiceUseCase(InvoiceGateway invoiceGateway) {
        return new BatchValidateInvoiceUseCaseImpl(invoiceGateway);
    }

    @Bean
    public CreateAgreementUseCase createAgreementUseCase(AgreementGateway agreementGateway) {
        return new CreateAgreementUseCaseImpl(agreementGateway);
    }

    @Bean
    public UpdateAgreementUseCase updateAgreementUseCase(AgreementGateway agreementGateway) {
        return new UpdateAgreementUseCaseImpl(agreementGateway);
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
