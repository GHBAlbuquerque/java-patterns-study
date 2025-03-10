package com.patterns.application.entrypoint.controller;

import com.patterns.domain.usecase.CreateBillUseCase;
import com.patterns.domain.usecase.GetBillUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {

    private final CreateBillUseCase billCreationUseCase;
    private final GetBillUseCase billGetUseCase;

    public BillController(CreateBillUseCase billCreationUseCase, GetBillUseCase billGetUseCase) {
        this.billCreationUseCase = billCreationUseCase;
        this.billGetUseCase = billGetUseCase;
    }

    @GetMapping
    public void getBill() {
        //TODO: Get a bill
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void createBill() {
        //TODO: Create a bill
    }
}
