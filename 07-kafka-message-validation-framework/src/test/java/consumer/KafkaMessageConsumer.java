package consumer;

import config.KafkaConfig;
import config.KafkaConsumerConfig;
import org.apache.kafka.clients.consumer.*;

import java.time.Duration;
import java.util.Collections;


public class KafkaMessageConsumer {


    public String consumeMessage() {

        Consumer<String,String> consumer =
                new KafkaConsumer<>(
                        KafkaConsumerConfig.getConsumerProperties()
                );


        consumer.subscribe(
                Collections.singletonList(
                        KafkaConfig.TOPIC_NAME
                )
        );


        ConsumerRecords<String,String> records =
                consumer.poll(Duration.ofSeconds(10));


        for(ConsumerRecord<String,String> record : records){

            System.out.println(
                    "Topic: " + record.topic()
            );

            System.out.println(
                    "Offset: " + record.offset()
            );

            consumer.commitSync();

            consumer.close();

            return record.value();
        }


        consumer.close();

        return null;
    }
}