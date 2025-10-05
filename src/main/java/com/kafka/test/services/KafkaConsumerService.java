package com.kafka.test.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "hello-topic", groupId = "my-consumer-group")
    public void listen(String message) {
        logger.info("Message Received: {}", message);
        System.out.println("Message Received:" + message);
    }
}
