package com.cognizant.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    /**
     * Alternative: Programmatic Route Configuration
     * This can be used instead of application.properties routes
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("external-service", r -> r
                .path("/api/external/**")
                .filters(f -> f
                    .addRequestHeader("X-Gateway-Route", "external-service")
                    .addResponseHeader("X-Gateway-Response", "routed")
                )
                .uri("https://jsonplaceholder.typicode.com"))
            
            .route("local-service", r -> r
                .path("/api/local/**")
                .uri("http://localhost:8080"))
            
            .route("httpbin-service", r -> r
                .path("/httpbin/**")
                .filters(f -> f
                    .rewritePath("/httpbin/?(?<remaining>.*)", "/${remaining}")
                    .addRequestHeader("X-Gateway-Source", "SpringCloudGateway")
                )
                .uri("http://httpbin.org"))
            
            .route("greet-service", r -> r
                .path("/greet/**")
                .filters(f -> f
                    .rewritePath("/greet/?(?<remaining>.*)", "/${remaining}")
                    .addRequestHeader("X-Custom-Header", "HelloFromGateway")
                )
                .uri("http://httpbin.org"))
            
            .route("retry-service", r -> r
                .path("/retry/**")
                .filters(f -> f
                    .rewritePath("/retry/?(?<remaining>.*)", "/${remaining}")
                    .retry(config -> config
                        .setRetries(3)
                        .setStatuses(
                            org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR,
                            org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE
                        )
                        .setMethods(
                            org.springframework.http.HttpMethod.GET,
                            org.springframework.http.HttpMethod.POST
                        )
                        .setSeries(
                            org.springframework.http.HttpStatus.Series.SERVER_ERROR
                        )
                    )
                )
                .uri("http://httpbin.org"))
            .build();
    }
}