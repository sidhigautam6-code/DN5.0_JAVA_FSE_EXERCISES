package com.cognizant.springcountrycodeapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
    
    private String code;  // Two-character ISO code (e.g., "IN", "US")
    private String name;  // Full country name (e.g., "India", "United States")
    
    /**
     * Default constructor
     */
    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }
    
    /**
     * Parameterized constructor
     */
    public Country(String code, String name) {
        LOGGER.debug("Inside Country Constructor with parameters.");
        this.code = code;
        this.name = name;
    }
    
    /**
     * Getter for code
     */
    public String getCode() {
        LOGGER.debug("Inside getCode() method.");
        return code;
    }
    
    /**
     * Setter for code
     */
    public void setCode(String code) {
        LOGGER.debug("Inside setCode() method. Setting code: {}", code);
        this.code = code;
    }
    
    /**
     * Getter for name
     */
    public String getName() {
        LOGGER.debug("Inside getName() method.");
        return name;
    }
    
    /**
     * Setter for name
     */
    public void setName(String name) {
        LOGGER.debug("Inside setName() method. Setting name: {}", name);
        this.name = name;
    }
    
    /**
     * toString method
     */
    @Override
    public String toString() {
        LOGGER.debug("Inside toString() method.");
        return "Country [code=" + code + ", name=" + name + "]";
    }
}