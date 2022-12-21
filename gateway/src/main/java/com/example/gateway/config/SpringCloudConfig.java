package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/bff/**")
                        .filters(f->f.rewritePath("/bff/(?<segment>.*)","/helper/v1/metaCapabilities"))
                        .uri("http://localhost:8080"))
//                        .id("employeeModule"))

                .route(r -> r.path("/consumer/message")
                        .filters(f->f.rewritePath("/consumer/message","/mobileoffice/resources/v1/carrierView"))
                        .uri("http://localhost:8080"))
//                        .id("consumerModule"))
                .build();
    }
}

