package com.cognizant.springcountrycodeapi.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springcountrycodeapi.Country;
import com.cognizant.springcountrycodeapi.service.CountryService;
import com.cognizant.springcountrycodeapi.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    
    private CountryService countryService = new CountryService();

    /**
     * GET endpoint that returns India country details
     * URL: http://localhost:8083/country
     * Method: GET
     * Response: JSON with India country details
     */
    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia()");
        
        Country country = null;
        try {
            country = countryService.getCountry("IN");
            LOGGER.debug("Country retrieved: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }
        
        LOGGER.info("END - getCountryIndia()");
        return country;
    }

    /**
     * GET endpoint that returns all countries
     * URL: http://localhost:8083/countries
     * Method: GET
     * Response: JSON array with all countries
     */
    @GetMapping("/countries")
    public ArrayList<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries()");
        
        ArrayList<Country> countries = countryService.getAllCountries();
        
        LOGGER.debug("Number of countries retrieved: {}", countries.size());
        for (Country country : countries) {
            LOGGER.debug("Country: {}", country);
        }
        
        LOGGER.info("END - getAllCountries()");
        return countries;
    }

    /**
     * ============================================================
     * MAIN ENDPOINT: GET Country Based on Country Code
     * ============================================================
     * URL: http://localhost:8083/countries/{code}
     * Method: GET
     * Description: Returns a specific country based on country code
     *              The country code is case insensitive
     * 
     * Example Requests:
     *   GET  http://localhost:8083/countries/IN   -> Returns India
     *   GET  http://localhost:8083/countries/US   -> Returns United States
     *   GET  http://localhost:8083/countries/in   -> Returns India (case insensitive)
     *   GET  http://localhost:8083/countries/de   -> Returns Germany (case insensitive)
     *   GET  http://localhost:8083/countries/AZ   -> Returns 404 Error (Country not found)
     * 
     * Response (Success - 200 OK):
     * {
     *   "code": "IN",
     *   "name": "India"
     * }
     * 
     * Response (Error - 404 Not Found):
     * {
     *   "timestamp": "2026-07-04T10:30:00.000+0000",
     *   "status": 404,
     *   "error": "Not Found",
     *   "message": "Country not found",
     *   "path": "/countries/AZ"
     * }
     */
    @GetMapping("/countries/{code}")
    public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START - getCountryByCode()");
        LOGGER.info("Requested Country Code: {}", code);
        
        // Convert code to uppercase for case-insensitive matching
        String upperCaseCode = code.toUpperCase();
        LOGGER.debug(" Converted to uppercase: {}", upperCaseCode);
        
        // Get country from service
        Country country = countryService.getCountry(upperCaseCode);
        
        LOGGER.debug(" Country found: {}", country);
        LOGGER.info("END - getCountryByCode()");
        return country;
    }
}