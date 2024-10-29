package com.apigateway.apigatewayserivce.config;

import org.springframework.boot.autoconfigure.web.client.RestClientBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClient() {
        return WebClient.builder();
    }

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }

    @Bean
    public RestClientBuilderConfigurer restClientBuilderConfigurer() {
        return new RestClientBuilderConfigurer();
    }

    @Bean
    public RestClient.Builder builder(RestClientBuilderConfigurer restClientBuilderConfigurer) {
        return restClientBuilderConfigurer.configure(RestClient.builder());
    }
}
