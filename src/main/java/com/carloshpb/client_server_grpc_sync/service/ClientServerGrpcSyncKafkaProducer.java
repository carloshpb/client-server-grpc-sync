package com.carloshpb.client_server_grpc_sync.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClientServerGrpcSyncKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(ClientServerGrpcSyncKafkaProducer.class);
    private static final String TOPIC = "topic_client_server_grpc_sync";

    private KafkaTemplate<String, String> kafkaTemplate;

    public ClientServerGrpcSyncKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info("Producing message to {} : {}", TOPIC, message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
