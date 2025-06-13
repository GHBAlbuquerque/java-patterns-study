package com.patterns.common.interfaces.gateways;

import com.patterns.common.dto.message.CustomQueueMessage;
import com.patterns.common.dto.request.PaymentEventDTO;

import java.util.List;

public interface PaymentEventGateway {

    void listenToPaymentUpdateEvents(List<CustomQueueMessage<PaymentEventDTO>> messages);

    void processPaymentUpdateEvent(CustomQueueMessage<PaymentEventDTO> message);

}
