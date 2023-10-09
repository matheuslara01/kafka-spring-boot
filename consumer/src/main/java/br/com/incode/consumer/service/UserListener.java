package br.com.incode.consumer.service;

import br.com.incode.consumer.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserListener {

    @KafkaListener(topics = "user-topic", groupId = "user-group", containerFactory = "containerFactory")
    public void consumeMessage(@Payload User user) {
        log.info("Reading user: {}", user);
    }
}
