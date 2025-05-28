package com.patterns.common.dto.response;

public record GetInvoiceStatusDTO(String id,
                                  String status) implements IResponse {
}

