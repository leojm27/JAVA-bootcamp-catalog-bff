package com.morales.catalog_bff.security;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    @Bean
    public RequestInterceptor basicAuthRequestInterceptor(){
        return template -> {
            String auth = this.username + ":" + this.password;
            String encodedAuth = java.util.Base64.getEncoder().encodeToString(auth.getBytes());
            template.header("Authorization", "Basic " + encodedAuth);
        };
    }

}
