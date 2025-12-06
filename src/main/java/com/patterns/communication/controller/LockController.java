package com.patterns.communication.controller;

import com.patterns.common.dto.request.LockDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/locks")
public class LockController {

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createLockToken(@RequestBody @Valid LockDTO lockDTO) {
        return ResponseEntity.ok("lock-token");
    }

    @GetMapping
    public boolean isValidLockToken(String token) {
        return true;
    }
}
