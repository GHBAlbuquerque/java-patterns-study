package com.patterns.communication.controller;

import com.patterns.common.dto.request.CreateInvoiceDTO;
import com.patterns.common.dto.request.InvoiceFilterRequest;
import com.patterns.common.dto.response.*;
import com.patterns.common.dto.validators.SingleFilterFinder;
import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.exception.custom.InvalidInvoiceException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.CreateInvoiceUseCase;
import com.patterns.common.interfaces.usecases.GetInvoiceUseCase;
import com.patterns.common.mapper.InvoiceMapper;
import com.patterns.common.properties.PropertiesMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.patterns.common.mapper.InvoiceMapper.*;


@Validated
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

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvoiceIdDTO> createInvoice(
            final @RequestBody @Validated CreateInvoiceDTO createInvoiceDTO
    ) throws InvalidInvoiceException {
        final var invoice = fromCreateDTOtoDomain(createInvoiceDTO);
        final var result = createInvoiceUseCase.createInvoice(invoice, gateway, properties);

        return ResponseEntity.ok(new InvoiceIdDTO(result.getId()));
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<GetInvoiceDTO> getInvoice(
            final @PathVariable String id
    ) throws EntityNotFoundException {
        final var result = getInvoiceUseCase.getInvoiceById(id, gateway);

        return ResponseEntity.ok(fromDomainToGetDTO(result));
    }

    @GetMapping(value = "/{id}/issuer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<GetInvoiceIssuerDTO> getInvoiceIssuerById(
            final @PathVariable String id
    ) throws EntityNotFoundException {
        final var result = getInvoiceUseCase.getInvoiceIssuerById(id, gateway);
        return ResponseEntity.ok(fromIssuerViewToDTO(result));
    }

    @GetMapping(value = "/{id}/status", consumes = "application/json", produces = "application/json")
    public ResponseEntity<GetInvoiceStatusDTO> getInvoiceStatusById(
            final @PathVariable String id
    ) throws EntityNotFoundException {
        final var result = getInvoiceUseCase.getInvoiceStatusById(id, gateway);
        return ResponseEntity.ok(fromStatusViewToDTO(result));
    }

    @GetMapping
    public <E extends IResponse> ResponseEntity<PagedResponse<E>> getInvoiceByFilter(
            final @Valid InvoiceFilterRequest filter,
            final @RequestParam(value = "page", defaultValue = "0") int page,
            final @RequestParam(value = "size", defaultValue = "10") int size
    ) {

        final var filterType = SingleFilterFinder.providedFilter(filter);
        final var response = getInvoiceUseCase.getInvoicesWithFilter(filter, page, size, filterType, gateway);

        final var convertedResponseContent = response.getContent().stream()
                .map(InvoiceMapper::fromDomainToGetDTO)
                .map(e -> (E) e) // Cast to E, assuming E extends IResponse
                .toList();

        final var pagedResponse = fromPageToPagedResponse(response, convertedResponseContent);

        return ResponseEntity.ok(pagedResponse);
    }
}
