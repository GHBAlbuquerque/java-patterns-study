package com.patterns.application.entrypoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {

    @GetMapping
    public void getBill() {
        //TODO: Get a bill
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void createBill() {
        //TODO: Create a bill
    }
}
