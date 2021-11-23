package com.olivine.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

/**
 * @Author jphao
 * @Date 17:41 2021/11/23
 * @Description
 */
@Slf4j
@Service
public class UserConsumer {

    @KafkaListener(topics = {"user"}, groupId = "user1")
    public void receive(ConsumerRecord<String, String> record, Acknowledgment ack){

        log.info("record:{}", record);
        ack.acknowledge();
    }

}
