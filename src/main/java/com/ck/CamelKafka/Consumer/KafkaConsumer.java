package com.ck.CamelKafka.Consumer;

import org.apache.camel.builder.RouteBuilder;

public class KafkaConsumer extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("kafka:kafka-topic1?brokers=localhost:9092")
                .log("Message received is : ${body}");
    }
}
