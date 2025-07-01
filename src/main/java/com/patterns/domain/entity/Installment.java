package com.patterns.domain.entity;

import com.patterns.domain.enums.InstallmentStatus;
import com.patterns.domain.enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Installment {
    private int number;
    private LocalDate dueDate;
    private LocalDate paymentDate;

    private BigDecimal amount;
    private BigDecimal paidAmount;
    private BigDecimal interest;

    private InstallmentStatus status;
    private PaymentMethod paymentMethod;
    private String notes;

}
