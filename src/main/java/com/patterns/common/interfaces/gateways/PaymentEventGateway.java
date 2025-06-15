package com.patterns.common.interfaces.gateways;

import com.patterns.common.dto.message.CustomQueueMessage;
import com.patterns.common.dto.message.ListWrapperQueueMessage;
import com.patterns.common.dto.request.PaymentEventDTO;

import java.util.List;

public interface PaymentEventGateway {

    void listenToPaymentUpdateEvents(ListWrapperQueueMessage<PaymentEventDTO> messages);

    void processPaymentUpdateEvent(CustomQueueMessage<PaymentEventDTO> message);

    List<CustomQueueMessage<PaymentEventDTO>> filterPaymentUpdateEventsByInvoicesCheck(List<CustomQueueMessage<PaymentEventDTO>> messages);

}
