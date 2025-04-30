package com.patterns.communication.controller;

import com.patterns.common.dto.request.CreateInvoiceDTO;
import com.patterns.common.dto.response.GetInvoiceDTO;
import com.patterns.common.dto.response.InvoiceIdDTO;
import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.exception.custom.InvalidInvoiceException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.CreateInvoiceUseCase;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.common.mapper.InvoiceMapper;
import com.patterns.common.properties.PropertiesMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceGateway gateway;
    private final CreateInvoiceUseCase createInvoiceUseCase;
    private final GetInvoiceUseCase getInvoiceUseCase;
    private final PropertiesMapper properties;

    public InvoiceController(InvoiceGateway invoiceGateway, CreateInvoiceUseCase invoiceCreationUseCase, GetInvoiceUseCase invoiceGetUseCase, PropertiesMapper properties) {
        this.gateway = invoiceGateway;
        this.createInvoiceUseCase = invoiceCreationUseCase;
        this.getInvoiceUseCase = invoiceGetUseCase;
        this.properties = properties;
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
    public ResponseEntity<InvoiceIdDTO> createInvoice(
            @RequestBody @Validated CreateInvoiceDTO createInvoiceDTO
    ) throws InvalidInvoiceException {
        final var invoice = InvoiceMapper.fromCreateDTOtoDomain(createInvoiceDTO);
        final var result = createInvoiceUseCase.createInvoice(invoice, gateway, properties);

        return ResponseEntity.ok(new InvoiceIdDTO(result.getId()));
    }
}
