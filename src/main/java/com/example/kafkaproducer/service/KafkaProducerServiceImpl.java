package com.example.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServiceImpl implements  KafkaProducerService {

    @Value("${topic.name.topic1}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String message) {

        kafkaTemplate.send(topicName, message)
            .addCallback(
                data -> System.out.println("Mensagem retornada com sucesso" + data.getProducerRecord().value() + data.getProducerRecord().topic()),
                err -> System.out.println("Falha no envio da mensagem "));
    }
}
