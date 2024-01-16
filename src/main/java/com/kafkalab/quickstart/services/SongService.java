package com.kafkalab.quickstart.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.kafkalab.quickstart.dto.SongDTO;

@Service
public class SongService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });
    }

    @KafkaListener(id = "songGroup", topics = "song")
    public void listen(SongDTO song) {
        System.out.println("Received: " + song + "|" + song.getClass());
    }
}