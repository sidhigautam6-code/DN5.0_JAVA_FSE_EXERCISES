package com.cognizant.springrestcountry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
    
    private String code;
    private String name;
    
    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }
    
    // Getters and setters...
}