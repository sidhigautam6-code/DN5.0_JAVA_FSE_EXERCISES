package com.cognizant.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;
import java.util.Set;

@Component
public class LogFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        long startTime = System.currentTimeMillis();
        
        // Log the request
        logRequest(request);
        
        // Continue with the filter chain and log response
        return chain.filter(exchange)
            .then(Mono.fromRunnable(() -> {
                long executionTime = System.currentTimeMillis() - startTime;
                logResponse(exchange, executionTime);
            }));
    }

    private void logRequest(ServerHttpRequest request) {
        // Get client IP
        InetSocketAddress remoteAddress = request.getRemoteAddress();
        String clientIp = remoteAddress != null ? remoteAddress.getHostString() : "unknown";
        
        // Get request details
        String method = request.getMethod().name();
        String path = request.getURI().getPath();
        String queryParams = request.getURI().getQuery();
        HttpHeaders headers = request.getHeaders();
        
        // Build log message
        StringBuilder logMessage = new StringBuilder();
        logMessage.append("\n========================================\n");
        logMessage.append("🚀 INCOMING REQUEST\n");
        logMessage.append("========================================\n");
        logMessage.append("📌 Timestamp: ").append(java.time.LocalDateTime.now()).append("\n");
        logMessage.append("📌 Client IP: ").append(clientIp).append("\n");
        logMessage.append("📌 Method: ").append(method).append("\n");
        logMessage.append("📌 Path: ").append(path).append("\n");
        
        if (queryParams != null && !queryParams.isEmpty()) {
            logMessage.append("📌 Query Params: ").append(queryParams).append("\n");
        }
        
        // Log headers
        logMessage.append("📌 Headers:\n");
        Set<String> headerNames = headers.keySet();
        for (String headerName : headerNames) {
            // Skip sensitive headers
            if (!headerName.equalsIgnoreCase("authorization") && 
                !headerName.equalsIgnoreCase("cookie") &&
                !headerName.equalsIgnoreCase("set-cookie")) {
                logMessage.append("   - ").append(headerName)
                         .append(": ").append(headers.getFirst(headerName)).append("\n");
            } else {
                logMessage.append("   - ").append(headerName).append(": [HIDDEN]\n");
            }
        }
        logMessage.append("========================================\n");
        
        logger.info(logMessage.toString());
    }

    private void logResponse(ServerWebExchange exchange, long executionTime) {
        ServerHttpRequest request = exchange.getRequest();
        int statusCode = exchange.getResponse().getStatusCode() != null ? 
                         exchange.getResponse().getStatusCode().value() : 0;
        
        StringBuilder logMessage = new StringBuilder();
        logMessage.append("\n========================================\n");
        logMessage.append("✅ RESPONSE\n");
        logMessage.append("========================================\n");
        logMessage.append("📌 Method: ").append(request.getMethod().name()).append("\n");
        logMessage.append("📌 Path: ").append(request.getURI().getPath()).append("\n");
        logMessage.append("📌 Status: ").append(statusCode).append("\n");
        logMessage.append("📌 Execution Time: ").append(executionTime).append("ms\n");
        logMessage.append("========================================\n");
        
        if (statusCode >= 200 && statusCode < 300) {
            logger.info(logMessage.toString());
        } else if (statusCode >= 400 && statusCode < 500) {
            logger.warn(logMessage.toString());
        } else if (statusCode >= 500) {
            logger.error(logMessage.toString());
        } else {
            logger.info(logMessage.toString());
        }
    }

    @Override
    public int getOrder() {
        return -1; // Run before other filters
    }
}