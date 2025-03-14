package com.patterns.application.entrypoint.controller;

import com.patterns.domain.usecase.CreatePaymentUseCase;
import com.patterns.domain.usecase.GetPaymentUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final CreatePaymentUseCase paymentCreationUseCase;
    private final GetPaymentUseCase paymentGetUseCase;

    public PaymentController(CreatePaymentUseCase paymentCreationUseCase, GetPaymentUseCase paymentGetUseCase) {
        this.paymentCreationUseCase = paymentCreationUseCase;
        this.paymentGetUseCase = paymentGetUseCase;
    }

    @GetMapping
    public void getPayment() {
        //TODO: Get a payment
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void createPayment() {
        //TODO: Create a payment
    }
}
