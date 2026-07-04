package com.cognizant.springrestcountry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestCountryApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestCountryApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START - SpringRestCountryApplication.main()");
        
        SpringApplication.run(SpringRestCountryApplication.class, args);
        
        LOGGER.info("END - SpringRestCountryApplication.main()");
    }
}