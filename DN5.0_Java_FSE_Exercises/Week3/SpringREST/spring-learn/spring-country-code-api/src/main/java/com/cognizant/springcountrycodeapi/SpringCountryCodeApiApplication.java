package com.cognizant.springcountrycodeapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCountryCodeApiApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringCountryCodeApiApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START - SpringCountryCodeApiApplication.main()");
        
        // Run the Spring Boot application
        SpringApplication.run(SpringCountryCodeApiApplication.class, args);
        
        LOGGER.info("END - SpringCountryCodeApiApplication.main()");
        LOGGER.info("============================================================");
        LOGGER.info("🚀 Application started successfully on port 8083");
        LOGGER.info("📌 API Endpoints:");
        LOGGER.info("   GET  /countries/{code}  - Get country by ISO code");
        LOGGER.info("   GET  /countries          - Get all countries");
        LOGGER.info("   GET  /country            - Get India");
        LOGGER.info("📌 Examples:");
        LOGGER.info("   http://localhost:8083/countries/IN  - Get India");
        LOGGER.info("   http://localhost:8083/countries/US  - Get United States");
        LOGGER.info("   http://localhost:8083/countries/in  - Case insensitive");
        LOGGER.info("============================================================");
    }
}