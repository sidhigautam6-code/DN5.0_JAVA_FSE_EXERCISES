package com.cognizant.springlearn.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);
    
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        LOGGER.info("JwtAuthorizationFilter initialized with authentication manager");
        LOGGER.debug("Authentication manager: {}", authenticationManager);
    }
    
    /**
     * Process the request and validate JWT token if present
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        
        LOGGER.info("Start doFilterInternal() for request: {}", request.getRequestURI());
        String header = request.getHeader("Authorization");
        LOGGER.debug("Authorization header: {}", header);
        
        // If no Authorization header or not Bearer token, continue the chain
        if (header == null || !header.startsWith("Bearer ")) {
            LOGGER.debug("No valid Bearer token found, continuing filter chain");
            chain.doFilter(request, response);
            LOGGER.info("End doFilterInternal() - No token validation performed");
            return;
        }
        
        // Validate the token and get authentication
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        
        if (authentication != null) {
            LOGGER.debug("Authentication successful for user: {}", authentication.getName());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            LOGGER.warn("Authentication failed - invalid token");
        }
        
        chain.doFilter(request, response);
        LOGGER.info("End doFilterInternal()");
    }
    
    /**
     * Validate JWT token and return authentication object
     */
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        LOGGER.info("Start getAuthentication() method");
        String token = request.getHeader("Authorization");
        LOGGER.debug("Processing token: {}", token);
        
        if (token == null) {
            LOGGER.debug("No token found in request");
            LOGGER.info("End getAuthentication() - null token");
            return null;
        }
        
        try {
            // Parse the JWT token
            Jws<Claims> jws = Jwts.parser()
                .setSigningKey("secretkey")
                .parseClaimsJws(token.replace("Bearer ", ""));
            
            String user = jws.getBody().getSubject();
            LOGGER.debug("Extracted user from token: {}", user);
            
            if (user != null) {
                LOGGER.info("Authentication successful for user: {}", user);
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
        } catch (JwtException ex) {
            LOGGER.error("JWT validation failed: {}", ex.getMessage());
            LOGGER.info("End getAuthentication() - JWT validation failed");
            return null;
        }
        
        LOGGER.info("End getAuthentication() - no valid user found");
        return null;
    }
}