package com.patterns.communication.dto.response;

import java.util.List;

public record PagedResponse<T extends IResponse>(
    List<T> invoices,
    int page,
    int size,
    long totalElements,
    int totalPages
) {
}
