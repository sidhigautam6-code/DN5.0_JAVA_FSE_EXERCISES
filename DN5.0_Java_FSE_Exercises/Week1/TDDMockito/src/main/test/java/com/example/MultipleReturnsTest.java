package com.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MultipleReturnsTest {
    
    private ExternalApi mockApi;
    private MyService service;
    
    @Before
    public void setUp() {
        System.out.println("🔧 Setting up Multiple Returns test...");
        mockApi = mock(ExternalApi.class);
        service = new MyService(mockApi);
    }
    
    @After
    public void tearDown() {
        System.out.println("🧹 Cleaning up test...");
    }
    
    // ===== EXERCISE 5: Mocking and Stubbing with Multiple Returns =====
    
    @Test
    public void testMultipleReturns_ConsecutiveCalls_DifferentValues() {
        System.out.println("\n📝 Testing: testMultipleReturns_ConsecutiveCalls_DifferentValues");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Stub with multiple return values
        System.out.println("📌 ARRANGE: Stubbing getData to return different values");
        when(mockApi.getData())
            .thenReturn("First Call")
            .thenReturn("Second Call")
            .thenReturn("Third Call");
        
        // ACT: Call the method multiple times
        System.out.println("📌 ACT: Calling getData multiple times");
        String result1 = service.fetchData();
        String result2 = service.fetchData();
        String result3 = service.fetchData();
        System.out.println("   - 1st call result: " + result1);
        System.out.println("   - 2nd call result: " + result2);
        System.out.println("   - 3rd call result: " + result3);
        
        // ASSERT: Verify each call returns different values
        System.out.println("📌 ASSERT: Verifying each call returns different value");
        assertEquals("First Call", result1);
        assertEquals("Second Call", result2);
        assertEquals("Third Call", result3);
        System.out.println("   - ✅ All values matched expected sequence");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testMultipleReturns_WithException_ThrowsExceptionOnLastCall() {
        System.out.println("\n📝 Testing: testMultipleReturns_WithException_ThrowsExceptionOnLastCall");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Stub with values and then exception
        System.out.println("📌 ARRANGE: Stubbing getData with values and exception");
        when(mockApi.getData())
            .thenReturn("First Call")
            .thenReturn("Second Call")
            .thenThrow(new RuntimeException("API Error"));
        
        // ACT: Call the method twice (should work)
        System.out.println("📌 ACT: Calling getData twice (should work)");
        String result1 = service.fetchData();
        String result2 = service.fetchData();
        System.out.println("   - 1st call: " + result1);
        System.out.println("   - 2nd call: " + result2);
        
        // ASSERT: First two calls work
        assertEquals("First Call", result1);
        assertEquals("Second Call", result2);
        System.out.println("   - ✅ First two calls returned expected values");
        
        // ACT & ASSERT: Third call throws exception
        System.out.println("📌 ACT & ASSERT: Third call should throw exception");
        try {
            service.fetchData();
            fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException e) {
            System.out.println("   - ✅ Exception caught: " + e.getMessage());
        }
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testMultipleReturns_GetUsers_ReturnsDifferentArrays() {
        System.out.println("\n📝 Testing: testMultipleReturns_GetUsers_ReturnsDifferentArrays");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Stub getUsers with multiple return values
        System.out.println("📌 ARRANGE: Stubbing getUsers with different arrays");
        when(mockApi.getUsers())
            .thenReturn(new String[]{"Alice", "Bob"})
            .thenReturn(new String[]{"Charlie", "David", "Eve"})
            .thenReturn(new String[]{"Frank"});
        
        // ACT: Call the method multiple times
        System.out.println("📌 ACT: Calling getUsers multiple times");
        String[] users1 = service.getUsers();
        String[] users2 = service.getUsers();
        String[] users3 = service.getUsers();
        System.out.println("   - 1st call: " + users1.length + " users");
        System.out.println("   - 2nd call: " + users2.length + " users");
        System.out.println("   - 3rd call: " + users3.length + " users");
        
        // ASSERT: Verify each call returns different arrays
        System.out.println("📌 ASSERT: Verifying arrays");
        assertEquals(2, users1.length);
        assertEquals(3, users2.length);
        assertEquals(1, users3.length);
        System.out.println("   - ✅ All arrays had different lengths");
        System.out.println("---------------------------------------------");
    }
}