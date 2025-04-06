package com.patterns.communication.gateway;

import com.patterns.common.dto.message.CustomQueueMessage;
import com.patterns.common.dto.request.UpdateInvoiceDTO;
import com.patterns.common.interfaces.gateways.MessagingGateway;

public class MessagingGatewayImpl implements MessagingGateway {

    @Override
    public void listenToInvoiceUpdate(CustomQueueMessage<UpdateInvoiceDTO> message) {
        //TODO
    }
}
