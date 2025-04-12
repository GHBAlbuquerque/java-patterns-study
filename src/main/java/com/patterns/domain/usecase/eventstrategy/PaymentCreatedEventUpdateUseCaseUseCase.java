package com.patterns.domain.usecase.eventstrategy;

import com.patterns.common.exception.ExceptionCodesEnum;
import com.patterns.common.exception.custom.UpdateEntityException;
import com.patterns.common.interfaces.external.MessageSender;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.patterns.domain.enums.PaymentEventsEnum.PAYMENT_CANCELLED;
import static com.patterns.domain.enums.StatusEnum.INACTIVE;

public class PaymentCreatedEventUpdateUseCaseUseCase extends EventUseCaseAbstract {

    private final Logger log = LogManager.getLogger(PaymentCreatedEventUpdateUseCaseUseCase.class);

    public PaymentCreatedEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway, MessageSender messageSender) {
        super(invoiceGateway, messageSender);
    }

    @Override
    public String getEventStatus() {
        return PAYMENT_CANCELLED;
    }

    @Override
    public String getInvoiceUpdateStatus() {
        return INACTIVE;
    }

    @Override
    public void updateInvoice(final String invoiceId) throws UpdateEntityException {
        try {
            log.info("Event received with status: {} and invoice id {}", getEventStatus(), invoiceId);

            final var optional = invoiceGateway.getInvoiceById(invoiceId);

            log.info("Updating invoice status to: {}", getInvoiceUpdateStatus());

            final var invoice = optional.orElseThrow();
            invoice.setStatus(getInvoiceUpdateStatus());
            invoiceGateway.saveInvoice(invoice);

            sendUpdateEvent(invoice, getInvoiceUpdateStatus());

        } catch (Exception e) {
            log.error("Error updating invoice status to: {}", getInvoiceUpdateStatus(), e);

            throw new UpdateEntityException(
                    ExceptionCodesEnum.INVOICE_03_INVOICE_UPDATE.name(),
                    String.format("Error updating invoice with Id %s. Exception type: %s, Message: %s", invoiceId, e.getClass(), e.getMessage()));
        }
    }

}
