package com.patterns.common.dto.validators;

import com.patterns.common.dto.request.InvoiceFilterRequest;
import com.patterns.domain.enums.FilterEnum;

import java.util.HashMap;
import java.util.Map;

public class SingleFilterFinder {

    private static final Map<String, String> PROVIDED_VALUES = new HashMap<>();

    public static FilterEnum providedFilter(InvoiceFilterRequest request) {
        PROVIDED_VALUES.put("barcode", request.barcode());
        PROVIDED_VALUES.put("status", request.status());
        PROVIDED_VALUES.put("minimumAmount", request.minimumAmount() != null ? String.valueOf(request.minimumAmount()) : null);
        PROVIDED_VALUES.put("maximumAmount", request.maximumAmount() != null ? String.valueOf(request.maximumAmount()) : null);
        PROVIDED_VALUES.put("startDate", request.startDate() != null ? String.valueOf(request.startDate()) : null);
        PROVIDED_VALUES.put("endDate", request.endDate() != null ? String.valueOf(request.endDate()) : null);
        PROVIDED_VALUES.put("issuer", request.issuer());

        if (request.barcode() != null && isSingleProvidedField("barcode")) {
            return FilterEnum.BARCODE;
        }

        if (request.status() != null && isSingleProvidedField("status")) {
            return FilterEnum.STATUS;
        }

        if (request.minimumAmount() != null && request.maximumAmount() != null
                && isSingleProvidedPairOfFields("minimumAmount", "maximumAmount")) {
            return FilterEnum.AMOUNT;
        }

        if (request.startDate() != null && request.endDate() != null
                && isSingleProvidedPairOfFields("startDate", "endDate")) {
            return FilterEnum.ISSUE_DATE;
        }

        if (request.issuer() != null && isSingleProvidedField("issuer")) {
            return FilterEnum.ISSUER;
        }

        return FilterEnum.MULTIPLE;
    }

    private static boolean isSingleProvidedField(String fieldName) {
        final var control = PROVIDED_VALUES.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(fieldName))
                .filter(entry -> entry.getValue() != null)
                .toList();

        return control.isEmpty();
    }

    private static boolean isSingleProvidedPairOfFields(String fieldName1, String fieldName2) {
        final var control = PROVIDED_VALUES.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(fieldName1) && !entry.getKey().equals(fieldName2))
                .filter(entry -> entry.getValue() != null)
                .toList();

        return control.isEmpty();
    }
}
