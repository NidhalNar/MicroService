package com.example.gateway;

import org.springframework.cloud.gateway.server.mvc.GatewayServerMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
@Import(GatewayServerMvcAutoConfiguration.class)
public class GatewayConfig {

    @Bean
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder(new RestTemplate());
    }
}
