package com.patterns.communication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    /*private final PaymentGateway gateway;
    private final GetPaymentUseCase getPaymentUseCase;

    @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<GetInvoiceDTO> getInvoice(
            @PathVariable String id
    ) throws EntityNotFoundException {
        final var result = GetPaymentUseCase.getPaymentById(id, gateway);

        return ResponseEntity.ok(InvoiceMapper.fromDomainToGetDTO(result));
    }

    @GetMapping(value = "/{id}/payment-method", consumes = "application/json", produces = "application/json")
    public ResponseEntity<GetPaymentMethodDTO> getPaymentMethod(
            @PathVariable String id
    ) throws EntityNotFoundException {
        final var result = GetPaymentUseCase.getPaymentMethodById(id, gateway);

        return ResponseEntity.ok(new GetPaymentMethodDTO(result.getId(), result.getInvoiceId(), result.getPaymentMethod()));
    }*/

}
