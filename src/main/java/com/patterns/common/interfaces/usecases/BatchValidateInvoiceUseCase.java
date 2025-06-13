package com.patterns.common.interfaces.usecases;

import com.patterns.domain.entity.Invoice;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface BatchValidateInvoiceUseCase {

    CompletableFuture<List<Boolean>> validateAllAsync(List<Invoice> invoices);

    CompletableFuture<Boolean> validateAsync(Invoice invoice);
}
