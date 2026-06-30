package com.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {
    
    private ExternalApi mockApi;
    private MyService service;
    
    @Before
    public void setUp() {
        System.out.println("🔧 Setting up test...");
        // Create mock object
        mockApi = mock(ExternalApi.class);
        service = new MyService(mockApi);
    }
    
    @After
    public void tearDown() {
        System.out.println("🧹 Cleaning up test...");
    }
    
    // ===== EXERCISE 1: Mocking and Stubbing =====
    
    @Test
    public void testFetchData_WithMockedApi_ShouldReturnMockData() {
        System.out.println("\n📝 Testing: testFetchData_WithMockedApi_ShouldReturnMockData");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Create mock and stub method
        System.out.println("📌 ARRANGE: Stubbing getData() to return 'Mock Data'");
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // ACT: Call the service method
        System.out.println("📌 ACT: Calling service.fetchData()");
        String result = service.fetchData();
        System.out.println("   - Result: " + result);
        
        // ASSERT: Verify the result
        System.out.println("📌 ASSERT: Verifying result");
        assertEquals("Mock Data", result);
        System.out.println("   - ✅ Test passed!");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testFetchUserData_WithMockedApi_ShouldReturnMockUserData() {
        System.out.println("\n📝 Testing: testFetchUserData_WithMockedApi_ShouldReturnMockUserData");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Stub getUserData method
        System.out.println("📌 ARRANGE: Stubbing getUserData(1) to return 'John Doe'");
        when(mockApi.getUserData(1)).thenReturn("John Doe");
        
        // ACT: Call the service method
        System.out.println("📌 ACT: Calling service.fetchUserData(1)");
        String result = service.fetchUserData(1);
        System.out.println("   - Result: " + result);
        
        // ASSERT: Verify the result
        System.out.println("📌 ASSERT: Verifying result");
        assertEquals("John Doe", result);
        System.out.println("   - ✅ Test passed!");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testFetchUserData_WithInvalidUserId_ShouldThrowException() {
        System.out.println("\n📝 Testing: testFetchUserData_WithInvalidUserId_ShouldThrowException");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Stub to throw exception
        System.out.println("📌 ARRANGE: Stubbing getUserData(-1) to throw exception");
        when(mockApi.getUserData(-1)).thenThrow(new IllegalArgumentException("Invalid user ID: -1"));
        
        // ACT & ASSERT: Verify exception is thrown
        System.out.println("📌 ACT & ASSERT: Calling service.fetchUserData(-1)");
        try {
            service.fetchUserData(-1);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("   - ✅ Exception caught: " + e.getMessage());
        }
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testMultipleStubs_WithDifferentArguments() {
        System.out.println("\n📝 Testing: testMultipleStubs_WithDifferentArguments");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Stub different responses for different arguments
        System.out.println("📌 ARRANGE: Stubbing multiple responses");
        when(mockApi.getUserData(1)).thenReturn("User 1: Alice");
        when(mockApi.getUserData(2)).thenReturn("User 2: Bob");
        when(mockApi.getUserData(3)).thenReturn("User 3: Charlie");
        
        // ACT & ASSERT
        System.out.println("📌 ACT & ASSERT: Testing multiple scenarios");
        assertEquals("User 1: Alice", service.fetchUserData(1));
        System.out.println("   - User 1: ✅");
        assertEquals("User 2: Bob", service.fetchUserData(2));
        System.out.println("   - User 2: ✅");
        assertEquals("User 3: Charlie", service.fetchUserData(3));
        System.out.println("   - User 3: ✅");
        System.out.println("   - ✅ All stubs returned correct values!");
        System.out.println("---------------------------------------------");
    }
}