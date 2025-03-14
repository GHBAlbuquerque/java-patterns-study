package com.patterns.communication.controller;

import com.patterns.common.dto.response.GetInvoiceDTO;
import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.CreateInvoiceUseCase;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.common.mapper.InvoiceMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceGateway gateway;
    private final CreateInvoiceUseCase createInvoiceUseCase;
    private final GetInvoiceUseCase getInvoiceUseCase;

    public InvoiceController(InvoiceGateway invoiceGateway, CreateInvoiceUseCase invoiceCreationUseCase, GetInvoiceUseCase invoiceGetUseCase) {
        this.gateway = invoiceGateway;
        this.createInvoiceUseCase = invoiceCreationUseCase;
        this.getInvoiceUseCase = invoiceGetUseCase;
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<GetInvoiceDTO> getInvoice(
            @PathVariable String id
    ) throws EntityNotFoundException {
        final var result = getInvoiceUseCase.getInvoiceById(id, gateway);

        return ResponseEntity.ok(InvoiceMapper.fromDomainToGetDTO(result));
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<GetInvoiceDTO> getInvoiceByBarcode(
            @RequestParam(required = true) String barcode
    ) throws EntityNotFoundException {
        final var result = getInvoiceUseCase.getInvoiceByBarcode(barcode, gateway);

        return ResponseEntity.ok(InvoiceMapper.fromDomainToGetDTO(result));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void createInvoice() {
        //TODO: Create a invoice
    }
}
