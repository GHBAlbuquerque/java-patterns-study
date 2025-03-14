package com.patterns.application.entrypoint.controller;

import com.patterns.domain.usecase.CreateInvoiceUseCase;
import com.patterns.domain.usecase.GetInvoiceUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final CreateInvoiceUseCase invoiceCreationUseCase;
    private final GetInvoiceUseCase invoiceGetUseCase;

    public InvoiceController(CreateInvoiceUseCase invoiceCreationUseCase, GetInvoiceUseCase invoiceGetUseCase) {
        this.invoiceCreationUseCase = invoiceCreationUseCase;
        this.invoiceGetUseCase = invoiceGetUseCase;
    }

    @GetMapping
    public void getInvoice() {
        //TODO: Get a invoice
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void createInvoice() {
        //TODO: Create a invoice
    }
}
