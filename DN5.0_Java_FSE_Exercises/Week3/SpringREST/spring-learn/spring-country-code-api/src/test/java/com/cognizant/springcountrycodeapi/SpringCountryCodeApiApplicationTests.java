package com.cognizant.springcountrycodeapi;

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

import com.cognizant.springcountrycodeapi.controller.CountryController;

@SpringBootTest
@AutoConfigureMockMvc
class SpringCountryCodeApiApplicationTests {

    @Autowired
    private CountryController countryController;
    
    @Autowired
    private MockMvc mvc;

    // ============================================================
    // TEST 1: Verify CountryController is loaded
    // ============================================================
    @Test
    void contextLoads() {
        System.out.println("============================================================");
        System.out.println("🧪 TEST 1: Checking if CountryController is loaded...");
        assertNotNull(countryController);
        System.out.println("✅ CountryController loaded successfully!");
        System.out.println("============================================================");
    }

    // ============================================================
    // TEST 2: Get Country by Code - Valid Code (IN)
    // ============================================================
    @Test
    void testGetCountryByCode_Valid_IN() throws Exception {
        System.out.println("============================================================");
        System.out.println("🧪 TEST 2: GET /countries/IN (Valid Code)");
        
        ResultActions actions = mvc.perform(get("/countries/IN"));
        
        actions.andExpect(status().isOk())
               .andExpect(jsonPath("$.code").exists())
               .andExpect(jsonPath("$.code").value("IN"))
               .andExpect(jsonPath("$.name").exists())
               .andExpect(jsonPath("$.name").value("India"));
        
        System.out.println("✅ GET /countries/IN - Success!");
        System.out.println("   Response: {\"code\":\"IN\",\"name\":\"India\"}");
        System.out.println("============================================================");
    }

    // ============================================================
    // TEST 3: Get Country by Code - Valid Code (US)
    // ============================================================
    @Test
    void testGetCountryByCode_Valid_US() throws Exception {
        System.out.println("============================================================");
        System.out.println("🧪 TEST 3: GET /countries/US (Valid Code)");
        
        ResultActions actions = mvc.perform(get("/countries/US"));
        
        actions.andExpect(status().isOk())
               .andExpect(jsonPath("$.code").value("US"))
               .andExpect(jsonPath("$.name").value("United States"));
        
        System.out.println("✅ GET /countries/US - Success!");
        System.out.println("   Response: {\"code\":\"US\",\"name\":\"United States\"}");
        System.out.println("============================================================");
    }

    // ============================================================
    // TEST 4: Get Country by Code - Case Insensitive (in)
    // ============================================================
    @Test
    void testGetCountryByCode_CaseInsensitive_Lowercase() throws Exception {
        System.out.println("============================================================");
        System.out.println("🧪 TEST 4: GET /countries/in (Case Insensitive - Lowercase)");
        
        ResultActions actions = mvc.perform(get("/countries/in"));
        
        actions.andExpect(status().isOk())
               .andExpect(jsonPath("$.code").value("IN"))
               .andExpect(jsonPath("$.name").value("India"));
        
        System.out.println("✅ GET /countries/in - Success!");
        System.out.println("   Response: {\"code\":\"IN\",\"name\":\"India\"}");
        System.out.println("   Note: Lowercase 'in' worked (case insensitive)!");
        System.out.println("============================================================");
    }

    // ============================================================
    // TEST 5: Get Country by Code - Case Insensitive (De - Mixed Case)
    // ============================================================
    @Test
    void testGetCountryByCode_CaseInsensitive_MixedCase() throws Exception {
        System.out.println("============================================================");
        System.out.println("🧪 TEST 5: GET /countries/De (Case Insensitive - Mixed Case)");
        
        ResultActions actions = mvc.perform(get("/countries/De"));
        
        actions.andExpect(status().isOk())
               .andExpect(jsonPath("$.code").value("DE"))
               .andExpect(jsonPath("$.name").value("Germany"));
        
        System.out.println("✅ GET /countries/De - Success!");
        System.out.println("   Response: {\"code\":\"DE\",\"name\":\"Germany\"}");
        System.out.println("   Note: Mixed case 'De' worked (case insensitive)!");
        System.out.println("============================================================");
    }

    // ============================================================
    // TEST 6: Get Country by Code - Invalid Code (AZ)
    // ============================================================
    @Test
    void testGetCountryByCode_Invalid_AZ() throws Exception {
        System.out.println("============================================================");
        System.out.println("🧪 TEST 6: GET /countries/AZ (Invalid Code)");
        
        ResultActions actions = mvc.perform(get("/countries/AZ"));
        
        actions.andExpect(status().isNotFound())
               .andExpect(jsonPath("$.message").value("Country not found"));
        
        System.out.println("✅ GET /countries/AZ - Error handled correctly!");
        System.out.println("   Response: 404 Not Found - Country not found");
        System.out.println("============================================================");
    }

    // ============================================================
    // TEST 7: Get Country by Code - Invalid Code (XX)
    // ============================================================
    @Test
    void testGetCountryByCode_Invalid_XX() throws Exception {
        System.out.println("============================================================");
        System.out.println("🧪 TEST 7: GET /countries/XX (Invalid Code)");
        
        ResultActions actions = mvc.perform(get("/countries/XX"));
        
        actions.andExpect(status().isNotFound())
               .andExpect(jsonPath("$.message").value("Country not found"));
        
        System.out.println("✅ GET /countries/XX - Error handled correctly!");
        System.out.println("============================================================");
    }

    // ============================================================
    // TEST 8: Get All Countries
    // ============================================================
    @Test
    void testGetAllCountries() throws Exception {
        System.out.println("============================================================");
        System.out.println("🧪 TEST 8: GET /countries (All Countries)");
        
        ResultActions actions = mvc.perform(get("/countries"));
        
        actions.andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray())
               .andExpect(jsonPath("$.length()").value(4))
               .andExpect(jsonPath("$[0].code").value("IN"))
               .andExpect(jsonPath("$[0].name").value("India"))
               .andExpect(jsonPath("$[1].code").value("US"))
               .andExpect(jsonPath("$[1].name").value("United States"));
        
        System.out.println("✅ GET /countries - Success!");
        System.out.println("   Retrieved 4 countries");
        System.out.println("============================================================");
    }
}