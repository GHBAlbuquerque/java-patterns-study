package com.patterns.common.entrypoint.controller;

import com.patterns.common.entrypoint.dto.GetInvoiceDTO;
import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.usecases.CreateInvoiceUseCase;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final CreateInvoiceUseCase createInvoiceUseCase;
    private final GetInvoiceUseCase getInvoiceUseCase;

    public InvoiceController(CreateInvoiceUseCase invoiceCreationUseCase, GetInvoiceUseCase invoiceGetUseCase) {
        this.createInvoiceUseCase = invoiceCreationUseCase;
        this.getInvoiceUseCase = invoiceGetUseCase;
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<GetInvoiceDTO> getInvoice(
            @PathVariable String id,
            @RequestParam(required = true) String type
    ) throws EntityNotFoundException {
        final var result = getInvoiceUseCase.getInvoice(id, type, gateway);

        return ResponseEntity.ok(ProductBuilder.toResponse(result));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void createInvoice() {
        //TODO: Create a invoice
    }
}
