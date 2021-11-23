package com.olivine.kafka;

import com.google.gson.Gson;
import com.olivine.kafka.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootKafkaApplicationTests {

    @Test
    void contextLoads() {
        User user = User.builder()
                .id(1)
                .name("lei")
                .uid("202111231738")
                .build();

        Gson gson = new Gson();
        System.out.println(gson.toJson(user));
    }

}
