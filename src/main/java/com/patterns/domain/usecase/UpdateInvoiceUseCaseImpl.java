package com.patterns.domain.usecase;

import com.patterns.common.exception.custom.EntityNotFoundException;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.common.interfaces.usecases.UpdateInvoiceUseCase;
import com.patterns.common.mapper.InvoiceMapper;
import com.patterns.domain.entity.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.patterns.domain.validator.ValidationMessageEnum.MSINV0001;

@Service
public class UpdateInvoiceUseCaseImpl implements UpdateInvoiceUseCase {

    private final Logger log = LoggerFactory.getLogger(UpdateInvoiceUseCaseImpl.class);
    private final InvoiceGateway invoiceGateway;

    public UpdateInvoiceUseCaseImpl(InvoiceGateway invoiceGateway) {
        this.invoiceGateway = invoiceGateway;
    }

    @Override
    public Invoice updateInvoice(String invoiceId, Invoice invoice)
        throws EntityNotFoundException {
        log.info("Attempting to update invoice with ID: {}", invoiceId);

        Invoice existingInvoice = invoiceGateway.getInvoiceById(invoiceId)
                .orElseThrow(() -> {
                    log.error("Invoice with ID {} not found for update.", invoiceId);
                    return new EntityNotFoundException(MSINV0001.getCode(), MSINV0001.getLogMessage());
                });

        InvoiceMapper.update(existingInvoice, invoice);

        Invoice updatedInvoice = invoiceGateway.updateInvoice(existingInvoice);
        log.info("Invoice with ID {} updated successfully.", invoiceId);
        return updatedInvoice;
    }
}
