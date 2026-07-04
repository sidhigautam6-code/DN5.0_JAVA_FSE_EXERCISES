package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
    
    /**
     * Configure in-memory authentication with users
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.info("Configuring authentication manager with in-memory users");
        
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password(passwordEncoder().encode("pwd"))
            .roles("ADMIN")
            .and()
            .withUser("user")
            .password(passwordEncoder().encode("pwd"))
            .roles("USER");
        
        LOGGER.info("Authentication manager configured with admin and user");
    }
    
    /**
     * Password encoder bean
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("Creating BCryptPasswordEncoder bean");
        return new BCryptPasswordEncoder();
    }
    
    /**
     * Configure HTTP security
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        LOGGER.info("Configuring HTTP security");
        
        httpSecurity
            .csrf().disable()
            .httpBasic().and()
            .authorizeRequests()
            .antMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()
            .and()
            .addFilter(new JwtAuthorizationFilter(authenticationManager()));
        
        LOGGER.info("HTTP security configured successfully");
    }
}