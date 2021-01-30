package com.example.kafka.springboot.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final String TOPIC="test_topic";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;
    public void sendMessage(String message){
        this.kafkaTemplate.send(TOPIC,message);
    }

    public void postMessage(Empdetails empdetails) throws JsonProcessingException {

        this.kafkaTemplate.send(TOPIC,objectMapper.writeValueAsString(empdetails));
    }
}
