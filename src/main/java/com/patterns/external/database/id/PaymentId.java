package com.patterns.external.database.id;

import jakarta.persistence.Id;

public class PaymentId {

    @Id
    private String id;

    @Id
    private String invoiceId;
}
