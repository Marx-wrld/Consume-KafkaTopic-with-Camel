package com.ck.CamelKafka.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public ResponseEntity<String> sendMessageToKafkaTopic(@RequestBody String message) {
        logger.info("Sending message to Kafka: {}", message);
        kafkaTemplate.send("kafka-topic1", message);
        logger.info("Message sent to Kafka: {}", message);
        return ResponseEntity.ok("Message sent to Kafka: " + message);
    }
}
