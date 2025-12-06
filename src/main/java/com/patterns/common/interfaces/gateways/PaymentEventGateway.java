package com.patterns.common.interfaces.gateways;

import com.patterns.communication.dto.message.CustomQueueMessage;
import com.patterns.communication.dto.message.ListWrapperQueueMessage;
import com.patterns.communication.dto.request.PaymentEventDTO;

import java.util.List;

public interface PaymentEventGateway {

    void listenToPaymentUpdateEvents(ListWrapperQueueMessage<PaymentEventDTO> messages);

    void processPaymentUpdateEvent(CustomQueueMessage<PaymentEventDTO> message);

    List<CustomQueueMessage<PaymentEventDTO>> filterPaymentUpdateEventsByInvoicesCheck(List<CustomQueueMessage<PaymentEventDTO>> messages);

}
