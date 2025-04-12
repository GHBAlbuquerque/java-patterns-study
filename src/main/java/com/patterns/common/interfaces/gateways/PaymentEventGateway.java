package com.patterns.common.interfaces.gateways;

import com.patterns.common.dto.message.CustomQueueMessage;
import com.patterns.common.dto.request.PaymentEventDTO;

public interface PaymentEventGateway {

    void listenToPaymentUpdateEvent(CustomQueueMessage<PaymentEventDTO> message);

}
