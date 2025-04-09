package com.patterns.common.beans;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import io.awspring.cloud.autoconfigure.sqs.SqsProperties;
import io.awspring.cloud.sqs.config.SqsBootstrapConfiguration;
import io.awspring.cloud.sqs.config.SqsMessageListenerContainerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;

@Configuration
@Import(SqsBootstrapConfiguration.class)
public class AWSSQSBeanDeclaration {

    @Value("${aws.region}")
    private String region;

    @Value("${aws.sqs.endpoint}")
    private String sqsEndpoint;

    @Bean
    public AmazonSQS amazonSQS() {

        final var endpointConfig = new AwsClientBuilder.EndpointConfiguration(sqsEndpoint, region);

        return AmazonSQSClient.builder()
                .withEndpointConfiguration(endpointConfig)
                .build();
    }

    @Bean
    public SqsMessageListenerContainerFactory<Object> defaultSqsListenerContainerFactory() {
        return SqsMessageListenerContainerFactory
                .builder()
                .sqsAsyncClient(sqsAsyncClient())
                .build();
    }

    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        final var endpoint = URI.create(sqsEndpoint);

        return SqsAsyncClient.builder()
                .endpointOverride(endpoint)
                .region(Region.of(region))
                .build();
    }

    @Bean
    public SqsProperties.Listener listener() {
        return new SqsProperties.Listener();
    }
}