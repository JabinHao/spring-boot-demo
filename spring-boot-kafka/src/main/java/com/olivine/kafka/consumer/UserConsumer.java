package com.olivine.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
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
        // 手动提交
        ack.acknowledge();
    }


    // 指定分区消费
    @KafkaListener(groupId = "user2", topicPartitions = {@TopicPartition(topic = "topic1", partitions = {"0", "1"}),
            @TopicPartition(topic = "topic2", partitions = "0", partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "5"))},
            concurrency = "3")
    public void consume(ConsumerRecord<String, String> record, Acknowledgment ack){

        log.info("record:{}", record);
        ack.acknowledge();
    }
}
