package com.finartz.demo.airlineticketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.finartz.demo.airlineticketing.model")
public class AirlineTicketingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirlineTicketingApplication.class, args);
    }

}
