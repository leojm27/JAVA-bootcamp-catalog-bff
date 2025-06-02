package com.morales.catalog_bff.security;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor basicAuthRequestInterceptor(){
        return template -> {
            String username = "admin";
            String password = "admin";
            String auth = username + ":" + password;
            String encodedAuth = java.util.Base64.getEncoder().encodeToString(auth.getBytes());
            template.header("Authorization", "Basic " + encodedAuth);
        };
    }

}
