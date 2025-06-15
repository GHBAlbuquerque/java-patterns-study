package com.patterns.domain.usecase;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.BatchValidateInvoiceUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class BatchValidateInvoiceUseCaseImpl implements BatchValidateInvoiceUseCase {

    private final Logger log = LoggerFactory.getLogger(BatchValidateInvoiceUseCaseImpl.class);

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
        return CompletableFuture.supplyAsync(() -> invoiceGateway.getInvoiceById(invoiceId).isPresent())
                .exceptionally(ex -> {
                    // Could implement error handling action here, like sending to a manual analysis queue
                    log.error("Validation failed for invoice {}, message: {} ", invoiceId, ex.getMessage());
                    return false;
                });
    }
}
