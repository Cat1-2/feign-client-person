package com.example.feign.config;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.okhttp.OkHttpClient;

import feign.Logger;

@Configuration
public class CustomFeignClientConfiguration {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("X-Auth-Code", "920d4d0b85443d98d86cb3c8c81d9eed");
        };
    }
    @Bean
    public ErrorDecoder errorDecoder() { return new FeignCustomErrorDecoder();}
}
