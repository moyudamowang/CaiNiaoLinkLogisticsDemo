package com.logistics.logisticssystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LogisticsSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticsSystemApplication.class, args);
    }

}
