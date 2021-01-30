package com.example.kafka.springboot.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    private final Producer producer;
    @Autowired
    public TestController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/publish")
        public void messageToTopic(@RequestParam("messages") String message){
        this.producer.sendMessage(message);
    }

    @PostMapping("/sent")
    public void newMessage(@RequestBody Empdetails empdetails) throws JsonProcessingException {
        this.producer.postMessage(empdetails);
    }

}
