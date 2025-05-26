package com.patterns.common.dto.request;

import com.patterns.common.dto.validators.annotations.ValidAmountRange;
import com.patterns.common.dto.validators.annotations.ValidDateRange;
import com.patterns.common.dto.validators.annotations.ValidSingleFilter;
import com.patterns.domain.enums.IssuerEnum;
import com.patterns.domain.enums.StatusEnum;
import jakarta.validation.constraints.AssertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;


@ValidAmountRange
@ValidDateRange
@ValidSingleFilter
public record InvoiceFilterRequest(

        String barcode,

        String status,

        BigDecimal minimumAmount,

        BigDecimal maximumAmount,

        LocalDate startDate,

        LocalDate endDate,

        String issuer,

        @AssertTrue(message = "User must agree to terms and conditions")
        boolean termsAndConditionsAccepted

) {

    @AssertTrue(message = "Invalid arguments.")
    public boolean isValid() {
        return isBarcodeValid() && isStatusValid() && isIssuerValid();
    }

    public boolean isBarcodeValid() {
        if (barcode != null) {
            return barcode.toLowerCase().matches("^0000[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
        }

        return true;
    }

    public boolean isStatusValid() {
        if (status != null) {
            return StatusEnum.contains(status.toUpperCase());
        }

        return true;
    }

    public boolean isIssuerValid() {
        if (issuer != null) {
            return IssuerEnum.contains(issuer.toUpperCase());
        }

        return true;
    }


}