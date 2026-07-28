package com.cognizant.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class AddRequestHeaderFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(AddRequestHeaderFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Generate unique request ID
        String requestId = UUID.randomUUID().toString();
        String timestamp = String.valueOf(System.currentTimeMillis());
        
        // Add custom headers to the request
        ServerWebExchange modifiedExchange = exchange.mutate()
            .request(exchange.getRequest().mutate()
                .header("X-Gateway-Request-Id", requestId)
                .header("X-Gateway-Timestamp", timestamp)
                .header("X-Gateway-Instance", "api-gateway-1")
                .build())
            .build();
        
        logger.debug("Added headers - RequestId: {}, Timestamp: {}", requestId, timestamp);
        
        return chain.filter(modifiedExchange);
    }

    @Override
    public int getOrder() {
        return 0; // Run after LogFilter
    }
}