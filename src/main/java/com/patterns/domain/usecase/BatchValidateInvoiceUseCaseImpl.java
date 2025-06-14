package com.patterns.domain.usecase;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.BatchValidateInvoiceUseCase;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BatchValidateInvoiceUseCaseImpl implements BatchValidateInvoiceUseCase {

    private final InvoiceGateway invoiceGateway;

    public BatchValidateInvoiceUseCaseImpl(InvoiceGateway invoiceGateway) {
        this.invoiceGateway = invoiceGateway;
    }

    @Override
    public CompletableFuture<List<Boolean>> validateAllAsync(List<String> invoicesIds) {
        List<CompletableFuture<Boolean>> futures = invoicesIds.stream()
                .map(this::validateAsync)
                .toList();

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .toList()
                );
    }

    @Override
    public CompletableFuture<Boolean> validateAsync(String invoiceId) {
        return CompletableFuture.supplyAsync(() -> invoiceGateway.getInvoiceById(invoiceId).isPresent());
    }
}
