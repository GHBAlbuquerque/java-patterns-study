package com.patterns.common.interfaces.gateways;

import com.patterns.common.dto.message.CustomQueueMessage;
import com.patterns.common.dto.request.PaymentEventDTO;

public interface MessagingGateway {

    void listenToInvoiceUpdate(CustomQueueMessage<PaymentEventDTO> message);

}
