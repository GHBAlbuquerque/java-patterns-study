package com.patterns.common.interfaces.external;

import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.patterns.common.exception.custom.MessageCreationException;

public interface MessageSender {

    SendMessageResult sendMessage(final Object object,
                                  final String queueUrl) throws MessageCreationException;

    SendMessageRequest createSendMessageRequest(final Object object,
                                                final String queueUrl) throws MessageCreationException;
}
