package com.patterns.common.interfaces.usecases;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface BatchValidateInvoiceUseCase {

    CompletableFuture<Map<String, Boolean>> validateAllAsync(List<String> invoicesIds);

    CompletableFuture<Boolean> validateAsync(String invoiceId);
}
