package com.patterns.domain.usecase.strategy;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.domain.entity.Invoice;
import com.patterns.domain.usecase.CreateInvoiceUseCaseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.patterns.domain.enums.EventsEnum.PAYMENT_CREATED;
import static com.patterns.domain.enums.StatusEnum.ACTIVE;

public class PaymentCancelledEventUpdateUseCaseUseCase extends EventUseCaseAbstract {

    private final Logger log = LogManager.getLogger(PaymentCancelledEventUpdateUseCaseUseCase.class);

    @Override
    public String getEventStatus() {
        return PAYMENT_CREATED;
    }

    @Override
    public String getInvoiceUpdateStatus() {
        return ACTIVE;
    }

    @Override
    public void updateInvoice(Invoice invoice, InvoiceGateway invoiceGateway) {
        log.info("Event received with status: {}", getEventStatus());

        log.info("Updating invoice status to: {}", getInvoiceUpdateStatus());

        invoice.setStatus(getInvoiceUpdateStatus());

        invoiceGateway.saveInvoice(invoice);
    }

}
