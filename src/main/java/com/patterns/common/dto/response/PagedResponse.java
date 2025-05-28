package com.patterns.common.dto.response;

import java.util.List;

public record PagedResponse<T extends IResponse>(
        int page,
        int size,
        long totalElements,
        int totalPages,
        List<T> invoices
) {
}
