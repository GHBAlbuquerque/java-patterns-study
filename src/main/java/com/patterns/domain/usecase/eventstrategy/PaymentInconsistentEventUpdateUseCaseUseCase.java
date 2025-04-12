package com.patterns.domain.usecase.eventstrategy;

import com.patterns.common.exception.ExceptionCodesEnum;
import com.patterns.common.exception.custom.UpdateEntityException;
import com.patterns.common.interfaces.external.MessageSender;
import com.patterns.common.interfaces.gateways.InvoiceGateway;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.patterns.domain.enums.PaymentEventsEnum.PAYMENT_INCONSISTENT;
import static com.patterns.domain.enums.StatusEnum.INCONSISTENT;

public class PaymentInconsistentEventUpdateUseCaseUseCase extends EventUseCaseAbstract {

    private final Logger log = LogManager.getLogger(PaymentInconsistentEventUpdateUseCaseUseCase.class);

    public PaymentInconsistentEventUpdateUseCaseUseCase(InvoiceGateway invoiceGateway, MessageSender messageSender) {
        super(invoiceGateway, messageSender);
    }

    @Override
    public String getEventStatus() {
        return PAYMENT_INCONSISTENT;
    }

    @Override
    public String getInvoiceUpdateStatus() {
        return INCONSISTENT;
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
