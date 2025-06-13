package com.patterns.domain.usecase;

import com.patterns.common.interfaces.usecases.BatchValidateInvoiceUseCase;
import com.patterns.domain.entity.Invoice;
import com.patterns.domain.validator.barcode.BarcodeValidator;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BatchValidateInvoiceUseCaseImpl implements BatchValidateInvoiceUseCase {

    private final BarcodeValidator barcodeValidator;

    public BatchValidateInvoiceUseCaseImpl(BarcodeValidator barcodeValidator) {
        this.barcodeValidator = barcodeValidator;
    }

    @Override
    public CompletableFuture<List<Boolean>> validateAllAsync(List<Invoice> invoices) {
        List<CompletableFuture<Boolean>> futures = invoices.stream()
                .map(this::validateAsync)
                .toList();

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .toList()
                );
    }

    @Override
    public CompletableFuture<Boolean> validateAsync(Invoice invoice) {
        return CompletableFuture.supplyAsync(() -> barcodeValidator.validate(
                invoice.getBarcode()).isValid()
        );
    }
}
