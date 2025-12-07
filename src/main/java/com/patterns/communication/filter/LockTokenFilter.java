package com.patterns.communication.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patterns.common.exception.model.ExceptionDetails;
import com.patterns.common.interfaces.gateways.LockGateway;
import com.patterns.common.interfaces.usecases.AcquireLockUseCase;
import com.patterns.external.database.orm.LockORM;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@ConditionalOnProperty(
    prefix = "app.features.lock-token-filter",
    name = "enabled",
    havingValue = "true",
    matchIfMissing = false
)
public class LockTokenFilter extends OncePerRequestFilter {

    private static final String LOCK_TOKEN_HEADER = "Lock-Token";
    private static final String USER_ID_HEADER = "X-User-Id";

    private static final Logger log = LoggerFactory.getLogger(LockTokenFilter.class);
    private final RequestMappingHandlerMapping requestMappingHandlerMapping;
    private final AcquireLockUseCase acquireLockUseCase;
    private final LockGateway lockGateway;
    private final ObjectMapper objectMapper;

    public LockTokenFilter(RequestMappingHandlerMapping requestMappingHandlerMapping,
                           AcquireLockUseCase acquireLockUseCase, LockGateway lockGateway,
                           ObjectMapper objectMapper) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
        this.acquireLockUseCase = acquireLockUseCase;
        this.lockGateway = lockGateway;
        this.objectMapper = objectMapper;
    }

    @Override
    protected boolean shouldNotFilter(@NotNull HttpServletRequest request) {
        try {
            HandlerExecutionChain handlerChain = requestMappingHandlerMapping.getHandler(request);
            if (handlerChain == null) {
                return true;
            }

            HandlerMethod handlerMethod = (HandlerMethod) handlerChain.getHandler();
            return !handlerMethod.hasMethodAnnotation(RequiresLockToken.class);
        } catch (Exception e) {
            log.debug("Could not determine handler method for request: {}", request.getRequestURI(), e);
            return true;
        }
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {

        String lockTokenHeader = request.getHeader(LOCK_TOKEN_HEADER);
        String userId = request.getHeader(USER_ID_HEADER);

        if (lockTokenHeader == null || lockTokenHeader.isEmpty()) {
            log.error("Endpoint requires Lock-Token, but it's missing.");
            sendErrorResponse(response,
                HttpStatus.UNAUTHORIZED,
                "Lock Token Missing",
                "Request Header missing Lock-Token");
            return;
        }

        if (userId == null || userId.isEmpty()) {
            log.error("Endpoint requires User-Id, but it's missing.");
            sendErrorResponse(response,
                HttpStatus.UNAUTHORIZED,
                "User ID Missing",
                "Request Header missing X-User-Id");
            return;
        }

        Optional<LockORM> optionalLock = acquireLockUseCase.getAndValidateLock(lockTokenHeader, userId, lockGateway);

        if (optionalLock.isEmpty()) {
            log.error("Lock with token {} is invalid or not found for user {}.", lockTokenHeader, userId);
            sendErrorResponse(response,
                HttpStatus.FORBIDDEN,
                "Invalid Lock",
                "The provided lock token is either expired, inactive, not found, or does not belong to the current user.");
            return;
        }

        log.info("Lock token {} validated successfully for user {}.", lockTokenHeader, userId);
        filterChain.doFilter(request, response);
    }

    private void sendErrorResponse(HttpServletResponse response,
                                   HttpStatus status,
                                   String title,
                                   String message) throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json");

        final ExceptionDetails errorResponse = new ExceptionDetails(
            title,
            LockTokenFilter.class.getName(),
            message,
            status.value(),
            LocalDateTime.now(),
            null);

        objectMapper.writeValue(response.getWriter(), errorResponse);
    }
}
