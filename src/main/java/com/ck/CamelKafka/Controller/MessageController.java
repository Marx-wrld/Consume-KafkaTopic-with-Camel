package com.ck.CamelKafka.Controller;

// Producer/Controller
// This class is responsible for sending messages to the Kafka topic using the KafkaTemplate.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public ResponseEntity<String> sendMessageToKafkaTopic(@RequestBody String message) {
        kafkaTemplate.send("kafka-topic1", message);
        return ResponseEntity.ok("Message sent to Kafka: " + message);
    }
}