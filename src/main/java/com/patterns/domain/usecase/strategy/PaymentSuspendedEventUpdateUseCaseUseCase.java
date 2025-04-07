package com.patterns.domain.usecase.strategy;

import com.patterns.common.interfaces.gateways.InvoiceGateway;
import com.patterns.domain.entity.Invoice;
import com.patterns.domain.usecase.CreateInvoiceUseCaseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.patterns.domain.enums.EventsEnum.PAYMENT_SUSPENDED;
import static com.patterns.domain.enums.StatusEnum.PAID;
import static com.patterns.domain.enums.StatusEnum.SUSPENDED;

public class PaymentSuspendedEventUpdateUseCaseUseCase extends EventUseCaseAbstract {

    private final Logger log = LogManager.getLogger(PaymentSuspendedEventUpdateUseCaseUseCase.class);

    @Override
    public String getEventStatus() {
        return PAYMENT_SUSPENDED;
    }

    @Override
    public String getInvoiceUpdateStatus() {
        return PAID;
    }

    @Override
    public void updateInvoice(Invoice invoice, InvoiceGateway invoiceGateway) {
        log.info("Event received with status: {}", getEventStatus());

        log.info("Updating invoice status to: {}", getInvoiceUpdateStatus());

        invoice.setStatus(getInvoiceUpdateStatus());

        invoiceGateway.saveInvoice(invoice);
    }

}
