package com.KaanIsmetOkul.CurrencyConverter.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    //configure the api
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
