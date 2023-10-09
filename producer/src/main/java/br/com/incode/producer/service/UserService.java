package br.com.incode.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.incode.producer.model.User;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(User user) {
        log.info("Sending message to kafka: {}", user);
        kafkaTemplate.send("user-topic", user);
    }

}