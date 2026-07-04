package main.java.com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    
    // Logger instance for logging
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
    
    // Instance variables
    private String code;    // Two-character ISO code (e.g., "IN", "US")
    private String name;    // Full country name (e.g., "India", "United States")
    
    /**
     * Empty parameter constructor
     * Logs when a Country object is created
     */
    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }
    
    /**
     * Parameterized constructor (optional)
     */
    public Country(String code, String name) {
        LOGGER.debug("Inside Country Constructor with parameters.");
        this.code = code;
        this.name = name;
    }
    
    /**
     * Getter for code
     * Logs when code is accessed
     */
    public String getCode() {
        LOGGER.debug("Inside getCode() method.");
        return code;
    }
    
    /**
     * Setter for code
     * Logs when code is set
     */
    public void setCode(String code) {
        LOGGER.debug("Inside setCode() method.");
        this.code = code;
    }
    
    /**
     * Getter for name
     * Logs when name is accessed
     */
    public String getName() {
        LOGGER.debug("Inside getName() method.");
        return name;
    }
    
    /**
     * Setter for name
     * Logs when name is set
     */
    public void setName(String name) {
        LOGGER.debug("Inside setName() method.");
        this.name = name;
    }
    
    /**
     * toString method
     * Returns string representation of Country object
     */
    @Override
    public String toString() {
        LOGGER.debug("Inside toString() method.");
        return "Country [code=" + code + ", name=" + name + "]";
    }
}