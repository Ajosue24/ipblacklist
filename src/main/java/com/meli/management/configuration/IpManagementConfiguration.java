package com.meli.management.configuration;


import com.squareup.moshi.Moshi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class IpManagementConfiguration {

    @Bean
    public WebClient getWebClientBuilderBuild() {
        return WebClient.builder().build();
    }
    @Bean
    public Moshi getMoshiBuilder() {
        return new Moshi.Builder().build();
    }


}
