package com.carloshpb.client_server_grpc_sync.web.rest;

import com.carloshpb.client_server_grpc_sync.ClientServerGrpcSyncApp;
import com.carloshpb.client_server_grpc_sync.service.ClientServerGrpcSyncKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = ClientServerGrpcSyncApp.class)
public class ClientServerGrpcSyncKafkaResourceIT {

    @Autowired
    private ClientServerGrpcSyncKafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        ClientServerGrpcSyncKafkaResource kafkaResource = new ClientServerGrpcSyncKafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/client-server-grpc-sync-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}
