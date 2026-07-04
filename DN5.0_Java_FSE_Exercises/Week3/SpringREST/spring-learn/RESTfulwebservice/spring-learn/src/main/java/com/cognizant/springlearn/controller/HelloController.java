package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Logger instance
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /**
     * GET endpoint that returns "Hello World!!"
     * URL: http://localhost:8083/hello
     * Method: GET
     * Response: "Hello World!!"
     */
    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("START - sayHello() method");
        
        String response = "Hello World!!";
        
        LOGGER.debug("Response: {}", response);
        LOGGER.info("END - sayHello() method");
        
        return response;
    }
}