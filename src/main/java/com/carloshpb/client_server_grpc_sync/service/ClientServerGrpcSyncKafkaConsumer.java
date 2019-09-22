package com.carloshpb.client_server_grpc_sync.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ClientServerGrpcSyncKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(ClientServerGrpcSyncKafkaConsumer.class);
    private static final String TOPIC = "topic_client_server_grpc_sync";

    @KafkaListener(topics = "topic_client_server_grpc_sync", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
