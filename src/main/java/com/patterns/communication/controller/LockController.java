package com.patterns.communication.controller;

import com.patterns.communication.dto.request.CreateLockDTO;
import com.patterns.communication.dto.response.LockDTO;
import com.patterns.common.exception.custom.LockAlreadyAcquiredException;
import com.patterns.common.interfaces.gateways.LockGateway;
import com.patterns.common.interfaces.usecases.AcquireLockUseCase;
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

    private final AcquireLockUseCase acquireLockUseCase;
    private final LockGateway lockGateway;

    public LockController(AcquireLockUseCase acquireLockUseCase, LockGateway lockGateway) {
        this.acquireLockUseCase = acquireLockUseCase;
        this.lockGateway = lockGateway;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<LockDTO> createLockToken(@RequestBody @Valid CreateLockDTO createLockDTO)
        throws LockAlreadyAcquiredException {

        final var result = acquireLockUseCase.acquireLock(createLockDTO, lockGateway);
        return ResponseEntity.ok(new LockDTO(result.getId()));
    }

    @GetMapping
    public boolean isValidLockToken(String token) {
        return true;
    }
}
