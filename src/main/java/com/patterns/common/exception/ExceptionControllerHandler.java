package com.patterns.common.exception;


import com.patterns.common.exception.custom.CreateEntityException;
import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.exception.custom.InvalidInvoiceException;
import com.patterns.common.exception.custom.LockAlreadyAcquiredException;
import com.patterns.common.exception.model.ExceptionDetails;
import jakarta.validation.ConstraintViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class ExceptionControllerHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LogManager.getLogger(ExceptionControllerHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatusCode status,
        WebRequest request) {

        final var errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach(violation -> {
            errors.put(violation.getObjectName().toString(), violation.getDefaultMessage());
        });

        final var message = new ExceptionDetails(
            "Method Argument Not Valid",
            ex.getClass().getName(),
            "Invalid arguments.",
            HttpStatus.BAD_REQUEST.value(),
            LocalDateTime.now(),
            errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDetails> handleConstraintViolationException(ConstraintViolationException ex) {
        final var errors = new HashMap<String, String>();
        ex.getConstraintViolations().forEach(violation -> {
            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
        });

        final var message = new ExceptionDetails(
            "Constraint Violation",
            ex.getClass().getName(),
            "Invalid arguments.",
            HttpStatus.BAD_REQUEST.value(),
            LocalDateTime.now(),
            errors);

        return ResponseEntity.badRequest().body(message);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ExceptionDetails> resourceException(EntityNotFoundException ex, WebRequest request) {

        final var message = new ExceptionDetails(
            "The requested resource was not found.",
            ex.getCode(),
            ex.getMessage(),
            HttpStatus.NOT_FOUND.value(),
            LocalDateTime.now(),
            ex.getErrors());

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {CreateEntityException.class})
    public ResponseEntity<ExceptionDetails> resourceException(CreateEntityException ex, WebRequest request) {

        final var message = new ExceptionDetails(
            "Couldn't create entity on database. Try again with different values.",
            ex.getCode(),
            ex.getMessage(),
            HttpStatus.BAD_REQUEST.value(),
            LocalDateTime.now(),
            ex.getErrors());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidInvoiceException.class})
    public ResponseEntity<ExceptionDetails> resourceException(InvalidInvoiceException ex, WebRequest request) {

        final var message = new ExceptionDetails(
            "Couldn't create entity on database. Try again with different values.",
            ex.getCode(),
            ex.getMessage(),
            HttpStatus.BAD_REQUEST.value(),
            LocalDateTime.now(),
            ex.getErrors());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {LockAlreadyAcquiredException.class})
    public ResponseEntity<ExceptionDetails> resourceException(LockAlreadyAcquiredException ex, WebRequest request) {

        final var message = new ExceptionDetails(
            "Resource lock conflict.",
            ex.getCode(),
            ex.getMessage(),
            HttpStatus.CONFLICT.value(),
            LocalDateTime.now(),
            ex.getErrors());

        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUncaughtException(Exception ex, WebRequest request) {
        log.error("Uncaught Exception. {}", ex.getMessage());
        log.error("Class: {}", ex.getClass());

        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        final var message = new ExceptionDetails(
            "Internal server error. Please contact the admin.",
            "NO-CODE",
            "Unindentified error.",
            status.value(),
            LocalDateTime.now(),
            null);

        return handleExceptionInternal(ex, message, new HttpHeaders(), status, request);
    }

}
