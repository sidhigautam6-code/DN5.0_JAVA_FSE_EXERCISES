package com.cognizant.springcountrycodeapi.service;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springcountrycodeapi.Country;
import com.cognizant.springcountrycodeapi.service.exception.CountryNotFoundException;

public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    
    private ArrayList<Country> countryList;

    /**
     * Constructor loads country list from XML configuration
     */
    @SuppressWarnings("unchecked")
    public CountryService() {
        LOGGER.info("START - CountryService Constructor");
        
        try {
            // Load Spring configuration from country.xml
            ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
            LOGGER.debug("ApplicationContext created successfully");
            
            // Get the country list bean
            countryList = context.getBean("countryList", ArrayList.class);
            
            LOGGER.debug(" Loaded {} countries from XML", countryList.size());
            
            // Display loaded countries
            for (Country country : countryList) {
                LOGGER.debug("   Loaded: {}", country);
            }
            
            // Close context
            ((ClassPathXmlApplicationContext) context).close();
            LOGGER.debug("ApplicationContext closed");
            
        } catch (Exception e) {
            LOGGER.error(" Error loading country list: {}", e.getMessage());
            countryList = new ArrayList<>();
        }
        
        LOGGER.info("END - CountryService Constructor");
    }

    /**
     * ============================================================
     * MAIN METHOD: Get Country by Code (Case Insensitive)
     * ============================================================
     * This method searches for a country by its ISO code.
     * The search is case insensitive (IN, in, In all work)
     * 
     * @param code Country ISO code (e.g., "IN", "US", "DE", "JP")
     * @return Country object if found
     * @throws CountryNotFoundException if country not found
     * 
     * Implementation uses Lambda expression with Stream API
     */
    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START - getCountry()");
        LOGGER.info("🔍 Searching for country with code: {}", code);
        
        // Method 1: Using Java 8 Stream with Lambda expression (Recommended)
        // This is more concise and functional programming approach
        Optional<Country> countryOptional = countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst();
        
        // Alternative Method 2: Using traditional for loop (Commented)
        /*
        for (Country country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                LOGGER.debug(" Country found using for loop: {}", country);
                return country;
            }
        }
        */
        
        if (countryOptional.isPresent()) {
            Country country = countryOptional.get();
            LOGGER.debug(" Country found: {}", country);
            LOGGER.info("END - getCountry() - Success");
            return country;
        }
        
        // Country not found - throw exception
        LOGGER.error(" Country not found with code: {}", code);
        throw new CountryNotFoundException("Country not found for code: " + code);
    }

    /**
     * Get all countries
     * @return List of all countries
     */
    public ArrayList<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries()");
        LOGGER.debug(" Returning {} countries", countryList.size());
        LOGGER.info("END - getAllCountries()");
        return countryList;
    }
    
    /**
     * Additional method to check if a country exists
     * @param code Country code to check
     * @return true if country exists, false otherwise
     */
    public boolean countryExists(String code) {
        LOGGER.debug("Checking if country exists: {}", code);
        return countryList.stream()
                .anyMatch(country -> country.getCode().equalsIgnoreCase(code));
    }
}