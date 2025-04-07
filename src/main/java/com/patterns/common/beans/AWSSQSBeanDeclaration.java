package com.patterns.common.beans;

import org.springframework.context.annotation.Configuration;

@Configuration
//@Import(SqsBootstrapConfiguration.class)
public class AWSSQSBeanDeclaration {

    //TODO
    /*@Bean
    public AmazonSQS amazonSQS() {
        return AmazonSQSClient.builder()
                .withRegion(String.valueOf(Region.US_EAST_1))
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
        return SqsAsyncClient.builder()
                .region(Region.US_EAST_1)
                .build();
    }

    @Bean
    public SqsProperties.Listener listener() {
        return new SqsProperties.Listener();
    }*/
}