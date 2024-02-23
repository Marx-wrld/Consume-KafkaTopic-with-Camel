package com.ck.CamelKafka.Consumer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("kafka:kafka-topic1?brokers=localhost:9092")
                .log("Message received is : ${body}")
                .to("direct:processMessage"); // Route the message to processMessage endpoint

        from("direct:processMessage")
                .log("Processing message: ${body}"); // Process the message received from Kafka
    }
}
