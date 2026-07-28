package com.cognizant.apigateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

    private static final Logger logger = LoggerFactory.getLogger(RateLimiterConfig.class);

    /**
     * Key Resolver based on client IP address
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> {
            String clientIp = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
            logger.debug("Rate limiting key: {}", clientIp);
            return Mono.just(clientIp);
        };
    }

    /**
     * Key Resolver based on user (requires authentication context)
     */
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> {
            // In a real application, get user from security context
            String user = "anonymous";
            // If using Spring Security, you can get it from SecurityContext
            // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            // if (auth != null && auth.isAuthenticated()) {
            //     user = auth.getName();
            // }
            return Mono.just(user);
        };
    }

    /**
     * Key Resolver based on API key or path
     */
    @Bean
    public KeyResolver apiKeyResolver() {
        return exchange -> {
            String apiKey = exchange.getRequest().getHeaders().getFirst("X-API-Key");
            if (apiKey == null) {
                apiKey = exchange.getRequest().getURI().getPath();
            }
            return Mono.just(apiKey);
        };
    }
}