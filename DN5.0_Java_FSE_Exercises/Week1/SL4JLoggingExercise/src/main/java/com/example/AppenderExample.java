package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        // Log messages will go to both console and file appenders
        logger.info("Application started with different appenders");
        
        // Different log levels
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
        
        // Simulate business logic
        processOrder("ORD-12345", 150.50);
        processOrder("ORD-12346", 275.30);
        processOrder("ORD-12347", -50.00);
    }
    
    private static void processOrder(String orderId, double amount) {
        logger.info("Processing order: {} with amount: ${}", orderId, amount);
        
        if (amount > 200) {
            logger.warn("Order {} exceeds $200 threshold - requiring approval", orderId);
        }
        
        if (amount < 0) {
            logger.error("Invalid amount for order {}: ${}", orderId, amount);
            return;
        }
        
        logger.info("Order {} processed successfully", orderId);
    }
}