package br.com.cardoso.controller;

import br.com.cardoso.model.RabbitMessage;
import br.com.cardoso.receiver.RabbitReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static br.com.cardoso.constants.Constants.ROUTING_KEY;
import static br.com.cardoso.constants.Constants.TOPIC_EXCHANGE_NAME;

@RestController
public class RabbitController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitController.class);
    private final RabbitTemplate rabbitTemplate;

    public RabbitController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody RabbitMessage rabbitMessage) {
        LOGGER.info("Sending message");
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, ROUTING_KEY + "." + rabbitMessage.key(), rabbitMessage.message());
        return ResponseEntity.ok().build();
    }
}
