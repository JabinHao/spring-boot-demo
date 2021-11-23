package com.olivine.kafka.controller;

import com.google.gson.Gson;
import com.olivine.kafka.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @Author jphao
 * @Date 17:35 2021/11/23
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    public static final String TOPIC_NAME = "user";
    public static final Gson JSON = new Gson();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void send() throws ExecutionException, InterruptedException {
        User user = User.builder()
                .id(1)
                .name("lei")
                .uid("202111231738")
                .build();

        String json = JSON.toJson(user);

        log.info("user: {}", json);

        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(TOPIC_NAME, json);
        System.out.println(send.get().getRecordMetadata().topic());
    }
}
