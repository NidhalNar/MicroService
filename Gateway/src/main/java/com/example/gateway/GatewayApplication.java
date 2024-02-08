package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("sponsor", r -> r.path("/sponsors/**", "/hello", "/h2")
                        .uri("http://localhost:8083/"))
                .route("media", r -> r.path("/medias/**")
                        .uri("http://localhost:8085/"))
                .route("Lieu", r -> r.path("/lieus/**")
                        .uri("http://localhost:8081/"))
                .route("event", r -> r.path("/evenements/**", "/h2")
                        .uri("http://localhost:8088/"))
                .route("reservation", r -> r.path("/reservation/**")
                        .uri("http://127.0.0.1:8000/"))
                .route("cand", r -> r.path("/api/candidats/**", "/h2")
                        .uri("http://localhost:8099/"))
                .build();
    }
}

