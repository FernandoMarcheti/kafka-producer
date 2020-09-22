package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/producer")
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping
    public ResponseEntity registerMessage(@RequestBody final String message) {
        kafkaProducerService.send(message);
        return ResponseEntity.ok().build();
    }
}
