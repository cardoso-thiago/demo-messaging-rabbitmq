package br.com.cardoso.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RabbitReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitReceiver.class);

    public void receiveMessage(String message) {
        LOGGER.info("Received message: {}", message);
    }
}
