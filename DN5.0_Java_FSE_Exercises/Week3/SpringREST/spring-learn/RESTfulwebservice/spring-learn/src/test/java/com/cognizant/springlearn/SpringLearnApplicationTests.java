package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.springlearn.controller.CountryController;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;
    
    @Autowired
    private MockMvc mvc;

    /**
     * Test 1: Verify that CountryController is loaded in Spring Context
     */
    @Test
    void contextLoads() {
        assertNotNull(countryController);
        System.out.println("✅ CountryController loaded successfully!");
    }

    /**
     * Test 2: Test GET /country endpoint - should return India
     */
    @Test
    void testGetCountry() throws Exception {
        System.out.println("🔄 Testing GET /country endpoint...");
        
        ResultActions actions = mvc.perform(get("/country"));
        
        actions.andExpect(status().isOk())
               .andExpect(jsonPath("$.code").exists())
               .andExpect(jsonPath("$.name").value("India"));
        
        System.out.println("✅ GET /country test passed!");
    }

    /**
     * Test 3: Test GET /countries endpoint - should return all countries
     */
    @Test
    void testGetAllCountries() throws Exception {
        System.out.println("🔄 Testing GET /countries endpoint...");
        
        ResultActions actions = mvc.perform(get("/countries"));
        
        actions.andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray())
               .andExpect(jsonPath("$.length()").value(4));
        
        System.out.println("✅ GET /countries test passed!");
    }

    /**
     * Test 4: Test GET /countries/{code} - valid country code
     */
    @Test
    void testGetCountryByCode() throws Exception {
        System.out.println("🔄 Testing GET /countries/IN endpoint...");
        
        ResultActions actions = mvc.perform(get("/countries/IN"));
        
        actions.andExpect(status().isOk())
               .andExpect(jsonPath("$.code").value("IN"))
               .andExpect(jsonPath("$.name").value("India"));
        
        System.out.println("✅ GET /countries/IN test passed!");
    }

    /**
     * Test 5: Test GET /countries/{code} - invalid country code (should throw exception)
     */
    @Test
    void testGetCountryException() throws Exception {
        System.out.println("🔄 Testing GET /countries/AZ (invalid country)...");
        
        ResultActions actions = mvc.perform(get("/countries/AZ"));
        
        actions.andExpect(status().isNotFound())
               .andExpect(jsonPath("$.message").value("Country not found"));
        
        System.out.println("✅ GET /countries/AZ exception test passed!");
    }
}