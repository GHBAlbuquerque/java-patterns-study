package com.patterns.common.interfaces.gateways;

import com.patterns.common.dto.message.CustomQueueMessage;
import com.patterns.common.dto.request.UpdateInvoiceDTO;

public interface MessagingGateway {

    void listenToInvoiceUpdate(CustomQueueMessage<UpdateInvoiceDTO> message);

}
