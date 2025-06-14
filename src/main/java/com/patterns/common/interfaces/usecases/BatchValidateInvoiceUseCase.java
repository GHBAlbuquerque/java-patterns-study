package com.patterns.common.interfaces.usecases;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface BatchValidateInvoiceUseCase {

    CompletableFuture<List<Boolean>> validateAllAsync(List<String> invoicesIds);

    CompletableFuture<Boolean> validateAsync(String invoiceId);
}
