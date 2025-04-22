package com.patterns.external.messaging;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patterns.common.exception.custom.MessageCreationException;
import com.patterns.common.interfaces.external.MessageSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderImpl implements MessageSender {

    private final AmazonSQS client;

    private final ObjectMapper objectMapper;

    private static final Logger logger = LogManager.getLogger(MessageSenderImpl.class);

    public MessageSenderImpl(AmazonSQS client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    @Override
    public SendMessageResult sendMessage(final Object object,
                                         final String queueUrl)
            throws MessageCreationException {

        return client.sendMessage(createSendMessageRequest(object, queueUrl));
    }

    @Override
    public SendMessageRequest createSendMessageRequest(final Object object,
                                                       final String queueUrl) throws MessageCreationException {
        try {
            return new SendMessageRequest()
                    .withQueueUrl(queueUrl)
                    .withMessageBody(objectMapper.writeValueAsString(object));

        } catch (Exception ex) {
            logger.error(
                    "Could not create message for queue: {}. Exception: {}",
                    queueUrl,
                    ex.getMessage()
            );

            throw new MessageCreationException(
                    "INV-001",
                    "Error creating SQS message. Exception: " + ex.getMessage());
        }
    }
}