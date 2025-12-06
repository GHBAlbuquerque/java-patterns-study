package com.patterns.communication.dto.response;

public record GetInvoiceIssuerDTO(String id,
                                  String issuer) implements IResponse {
}

