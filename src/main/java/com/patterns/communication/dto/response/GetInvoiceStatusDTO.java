package com.patterns.communication.dto.response;

public record GetInvoiceStatusDTO(String id,
                                  String status) implements IResponse {
}

