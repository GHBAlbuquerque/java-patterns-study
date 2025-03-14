package com.patterns.domain.usecase;

import com.patterns.common.exception.custom.InvalidInvoiceException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.CreateInvoiceUseCase;
import com.patterns.common.properties.PropertiesMapper;
import com.patterns.domain.entity.Invoice;
import com.patterns.domain.validator.ValidationMessageEnum;
import com.patterns.domain.validator.ValidationResult;
import com.patterns.domain.validator.amount.MaximumAmountValidator;
import com.patterns.domain.validator.amount.MinimumAmountValidator;
import com.patterns.domain.validator.amount.NegativeAmountValidator;
import com.patterns.domain.validator.date.BusinessDayValidator;
import com.patterns.domain.validator.date.FutureDateValidator;
import com.patterns.domain.validator.date.RetroactiveDateValidator;
import com.patterns.domain.validator.issuer.KnownIssuersValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV0003;

public class CreateInvoiceUseCaseImpl implements CreateInvoiceUseCase {

    private final Logger logger = LogManager.getLogger(CreateInvoiceUseCaseImpl.class);
    private final PropertiesMapper properties = new PropertiesMapper();

    @Override
    public Invoice createInvoice(Invoice invoice, InvoiceGateway gateway) throws InvalidInvoiceException {

        validateInvoiceRequest(invoice);

        logger.info("Completing information for Invoice creation: generating barcode and id.");

        final var barcode = generateBarcode();
        final var id = generateInvoiceId();

        invoice.setBarcode(barcode);
        invoice.setId(id);

        logger.info("Persisting invoice.");

        return gateway.saveInvoice(invoice);
    }

    @Override
    public String generateInvoiceId() {
        final var random = new SecureRandom();

        return properties.getInvoiceIdPreffix()
                + LocalDate.now()
                + random.nextInt(999999)
                + properties.getInvoiceIdSuffix();
    }


    @Override
    public String generateBarcode() {
        return properties.getInvoiceBarcodePreffix() + UUID.randomUUID();
    }

    @Override
    public void validateInvoiceRequest(Invoice invoice) throws InvalidInvoiceException {
        logger.info("Validating invoice creation request.");

        final var validations = List.of(
                validateDueDate(invoice.getDueDate()),
                validateIssueDate(invoice.getIssueDate()),
                validateIssuer(invoice.getIssuer()),
                validateAmount(invoice.getAmount())
        );

        final var validationMessages = validations.stream().map(ValidationResult::getMessage).toList();

        if (validationMessages.isEmpty()) {
            logger.info("Invoice creation request is valid.");
            return;
        }

        logger.info("Errors found in Invoice creation request.");
        final var errors = new HashMap<String, String>();

        for (ValidationMessageEnum message : validationMessages) {
            errors.put(message.getCode(), message.getLogMessage());
        }

        throw new InvalidInvoiceException(MSINV0003.getCode(),
                MSINV0003.getLogMessage(),
                errors);
    }

    private ValidationResult validateDueDate(LocalDate dueDate) {
        logger.info("Validating Due Date...");

        return new BusinessDayValidator()
                .linkWith(new RetroactiveDateValidator())
                .validate(dueDate);
    }

    private ValidationResult validateIssueDate(LocalDate issueDate) {
        logger.info("Validating Issue Date...");

        return new BusinessDayValidator()
                .linkWith(new FutureDateValidator())
                .validate(issueDate);
    }

    private ValidationResult validateIssuer(String issuer) {
        logger.info("Validating Issuer...");

        return new KnownIssuersValidator().validate(issuer);
    }

    private ValidationResult validateAmount(BigDecimal amount) {
        logger.info("Validating Amount...");

        return new NegativeAmountValidator()
                .linkWith(new MaximumAmountValidator())
                .linkWith(new MinimumAmountValidator())
                .validate(amount);
    }
}
