package com.patterns.domain.usecase;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.BatchValidateInvoiceUseCase;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class BatchValidateInvoiceUseCaseImpl implements BatchValidateInvoiceUseCase {

    private final InvoiceGateway invoiceGateway;

    public BatchValidateInvoiceUseCaseImpl(InvoiceGateway invoiceGateway) {
        this.invoiceGateway = invoiceGateway;
    }

    @Override
    public CompletableFuture<Map<String, Boolean>> validateAllAsync(List<String> invoicesIds) {
        Map<String, CompletableFuture<Boolean>> futureMap = invoicesIds.stream()
                .collect(Collectors.toMap(
                        invoiceId -> invoiceId, this::validateAsync
                ));

        CompletableFuture<?>[] futures = futureMap.values().toArray(new CompletableFuture[0]);

        return CompletableFuture.allOf(futures)
                .thenApply(v -> futureMap.entrySet().stream()
                        .collect(Collectors.toMap(
                                entry -> entry.getKey(),
                                entry -> entry.getValue().join()
                        )));
    }

    @Override
    public CompletableFuture<Boolean> validateAsync(String invoiceId) {
        return CompletableFuture.supplyAsync(() -> invoiceGateway.getInvoiceById(invoiceId).isPresent());
    }
}
