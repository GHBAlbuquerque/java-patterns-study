package com.patterns.communication.controller;

import com.patterns.communication.dto.request.CreateLockDTO;
import com.patterns.communication.dto.response.LockDTO;
import com.patterns.common.exception.custom.LockAlreadyAcquiredException;
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

    public LockController(AcquireLockUseCase acquireLockUseCase) {
        this.acquireLockUseCase = acquireLockUseCase;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<LockDTO> createLockToken(@RequestBody @Valid CreateLockDTO createLockDTO)
        throws LockAlreadyAcquiredException {

        final var result = acquireLockUseCase.acquireLock(createLockDTO);
        return ResponseEntity.ok(new LockDTO(result.getId()));
    }

    @GetMapping
    public boolean isValidLockToken(String token) {
        //TODO
        return true;
    }
}
