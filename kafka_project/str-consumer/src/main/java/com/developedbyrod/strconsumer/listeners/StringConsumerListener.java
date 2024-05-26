package com.developedbyrod.strconsumer.listeners;
import com.developedbyrod.strconsumer.custom.StrCustomConsumerListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StringConsumerListener {


    @StrCustomConsumerListener(topics ="str-topic", groupId = "group-1")
    public void create(String message){
        log.info("CREATE ::: Message received: {}", message);
    }

    @StrCustomConsumerListener(topics = "str-topic", groupId = "group-2")
    public void log(String message){
        log.info("LOG ::: Message received: {}", message);
    }

    @KafkaListener(containerFactory="validMessageContainerFactory", groupId = "group-3", topics = "new-topic")
    public void history(String message){
        log.info("HISTORY - validMessageContainerFactory :::  Message received: {}", message);
    }

}
