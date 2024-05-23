package com.developedbyrod.strconsumer.listeners;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StringConsumerListener {


    @KafkaListener(groupId = "group-one", topics = "str-topic", containerFactory = "stringContainerFactory")
    public void listener(String message){
        log.info("Message received: {}", message);
    }
}
