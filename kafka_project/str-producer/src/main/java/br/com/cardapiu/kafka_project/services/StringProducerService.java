package br.com.cardapiu.kafka_project.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {


    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("string-topic", message).thenAccept(
                success -> {
                    if(success != null){
                        log.info("Mensagem enviada: " + message);
                        log.info("Partition {}, Offset {}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
                    }
                }
                ).exceptionally(
                error -> {
                    log.error("Erro ao enviar mensagem: " + message);
                    return null;
                }
        );
    }
}
