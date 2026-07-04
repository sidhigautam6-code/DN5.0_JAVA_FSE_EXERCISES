package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    
    /**
     * Authenticate user and return JWT token
     * 
     * @param authHeader Authorization header with Basic authentication
     * @return Map containing the JWT token
     */
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authenticate() method");
        LOGGER.debug("Authorization header: {}", authHeader);
        
        String user = getUser(authHeader);
        LOGGER.debug("Extracted user: {}", user);
        
        String token = generateJwt(user);
        LOGGER.debug("Generated JWT token: {}", token);
        
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        
        LOGGER.info("End authenticate() method");
        return response;
    }
    
    /**
     * Extract username from Basic Authentication header
     * 
     * @param authHeader Authorization header containing Basic credentials
     * @return Username extracted from the credentials
     */
    private String getUser(String authHeader) {
        LOGGER.info("Start getUser() method");
        LOGGER.debug("Processing Authorization header: {}", authHeader);
        
        try {
            // Remove "Basic " prefix and decode Base64
            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes);
            LOGGER.debug("Decoded credentials: {}", credentials);
            
            // Extract username before colon
            String user = credentials.substring(0, credentials.indexOf(':'));
            LOGGER.debug("Extracted username: {}", user);
            
            LOGGER.info("End getUser() method");
            return user;
        } catch (Exception e) {
            LOGGER.error("Error extracting user from Authorization header", e);
            throw new RuntimeException("Invalid Authorization header", e);
        }
    }
    
    /**
     * Generate JWT token for the authenticated user
     * 
     * @param user Username to set as subject
     * @return Generated JWT token
     */
    private String generateJwt(String user) {
        LOGGER.info("Start generateJwt() method for user: {}", user);
        
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        
        // Set token issue time as current time
        Date issuedAt = new Date();
        builder.setIssuedAt(issuedAt);
        LOGGER.debug("Token issued at: {}", issuedAt);
        
        // Set token expiry as 20 minutes from now
        Date expiration = new Date(issuedAt.getTime() + 1200000);
        builder.setExpiration(expiration);
        LOGGER.debug("Token expires at: {}", expiration);
        
        // Sign the token with secret key
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");
        
        String token = builder.compact();
        LOGGER.debug("Generated token: {}", token);
        
        LOGGER.info("End generateJwt() method");
        return token;
    }
}