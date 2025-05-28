package com.patterns.common.dto.response;

public record GetInvoiceIssuerDTO(String id,
                                  String issuer) implements IResponse {
}

