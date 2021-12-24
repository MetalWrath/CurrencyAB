package com.ancient.currencyab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyAbApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyAbApplication.class, args);
    }

}
