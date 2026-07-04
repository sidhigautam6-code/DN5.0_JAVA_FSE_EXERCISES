package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    
    private CountryService countryService = new CountryService();

    @GetMapping("/country")
    public Country getCountryIndia() throws CountryNotFoundException {
        LOGGER.info("START - getCountryIndia()");
        
        Country country = countryService.getCountry("IN");
        
        LOGGER.info("END - getCountryIndia()");
        return country;
    }

    @GetMapping("/countries")
    public ArrayList<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries()");
        
        ArrayList<Country> countries = countryService.getAllCountries();
        
        LOGGER.info("END - getAllCountries()");
        return countries;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START - getCountry()");
        
        Country country = countryService.getCountry(code.toUpperCase());
        
        LOGGER.info("END - getCountry()");
        return country;
    }
}