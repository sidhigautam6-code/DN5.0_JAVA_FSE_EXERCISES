package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

    // Logger instance for the class
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        // Log application start
        LOGGER.info("START - SpringLearnApplication.main()");
        
        // Run the Spring Boot application
        SpringApplication.run(SpringLearnApplication.class, args);
        
        // Log application end
        LOGGER.info("END - SpringLearnApplication.main()");
    }
}