package com.carloshpb.client_server_grpc_sync.web.rest;

import com.carloshpb.client_server_grpc_sync.service.ClientServerGrpcSyncKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/client-server-grpc-sync-kafka")
public class ClientServerGrpcSyncKafkaResource {

    private final Logger log = LoggerFactory.getLogger(ClientServerGrpcSyncKafkaResource.class);

    private ClientServerGrpcSyncKafkaProducer kafkaProducer;

    public ClientServerGrpcSyncKafkaResource(ClientServerGrpcSyncKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
