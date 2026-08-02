package tests;

import consumer.KafkaMessageConsumer;
import org.junit.jupiter.api.Test;
import validation.MessageValidator;

import static org.junit.jupiter.api.Assertions.*;

public class KafkaMessageValidationTest {


    @Test
    public void validateKafkaMessage() {

        KafkaMessageConsumer consumer =
                new KafkaMessageConsumer();


        String actualMessage =
                consumer.consumeMessage();


        MessageValidator validator =
                new MessageValidator();


        boolean result =
                validator.validate(
                        actualMessage,
                        "Hello Kafka! This is my first testing message."
                );


        assertTrue(result);

    }
}