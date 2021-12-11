package com.olivine.mapstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author jphao
 * @Date 17:32 2021/12/07
 * @Description
 */
@MapperScan("com.olivine.mapstruct.mapper")
@SpringBootApplication
public class MapstructApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapstructApplication.class, args);
    }
}
