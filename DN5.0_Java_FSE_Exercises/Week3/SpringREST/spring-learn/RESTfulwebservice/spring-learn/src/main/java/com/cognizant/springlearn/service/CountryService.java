package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    
    private ArrayList<Country> countryList;

    @SuppressWarnings("unchecked")
    public CountryService() {
        LOGGER.info("START - CountryService Constructor");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        countryList = context.getBean("countryList", ArrayList.class);
        
        LOGGER.info("END - CountryService Constructor");
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START - getCountry()");
        
        for (Country country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                LOGGER.info("END - getCountry() - Country found");
                return country;
            }
        }
        
        LOGGER.error("Country not found with code: {}", code);
        throw new CountryNotFoundException("Country not found");
    }

    public ArrayList<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries()");
        LOGGER.info("END - getAllCountries()");
        return countryList;
    }
}