package com.cognizant.springcountrycodeapi.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception for country not found scenarios
 * When thrown, Spring returns HTTP 404 with the specified reason
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor with custom message
     * @param message The error message
     */
    public CountryNotFoundException(String message) {
        super(message);
        // Log the exception (would use Logger in real implementation)
    }
}