package com.patterns.domain.entity;

import java.util.List;

public class Agreement {
    private String id;
    private List<Installment> installments;
    private List<Invoice> invoices; // ✅ Value Object
}
