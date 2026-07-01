package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        // Example 1: Single parameter
        String username = "john_doe";
        logger.info("User {} logged in successfully", username);
        
        // Example 2: Multiple parameters
        int loginAttempts = 3;
        logger.warn("User {} has {} failed login attempts", username, loginAttempts);
        
        // Example 3: Different data types
        double temperature = 23.5;
        boolean isActive = true;
        logger.info("Temperature: {}, Active status: {}", temperature, isActive);
        
        // Example 4: Exception with parameters
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Error during division: {} / {}", 10, 0, e);
        }
        
        // Example 5: Object parameters
        User user = new User("alice", 25);
        logger.info("User details: {}", user);
    }
    
    // Inner class for demonstration
    static class User {
        private String name;
        private int age;
        
        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return "User{name='" + name + "', age=" + age + "}";
        }
    }
}