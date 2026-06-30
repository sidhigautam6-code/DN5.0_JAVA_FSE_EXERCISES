package com.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArgumentMatchersTest {
    
    private ExternalApi mockApi;
    private MyService service;
    
    @Before
    public void setUp() {
        System.out.println("🔧 Setting up Argument Matchers test...");
        mockApi = mock(ExternalApi.class);
        service = new MyService(mockApi);
    }
    
    @After
    public void tearDown() {
        System.out.println("🧹 Cleaning up test...");
    }
    
    // ===== EXERCISE 3: Argument Matching =====
    
    @Test
    public void testArgumentMatchers_AnyInt_ShouldMatchAnyInteger() {
        System.out.println("\n📝 Testing: testArgumentMatchers_AnyInt_ShouldMatchAnyInteger");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Use argument matcher for stubbing
        System.out.println("📌 ARRANGE: Stubbing getUserData with anyInt()");
        when(mockApi.getUserData(anyInt())).thenReturn("Generic User Data");
        
        // ACT: Call with different arguments
        System.out.println("📌 ACT: Calling with different user IDs");
        String result1 = service.fetchUserData(1);
        String result2 = service.fetchUserData(100);
        String result3 = service.fetchUserData(999);
        System.out.println("   - Result for ID 1: " + result1);
        System.out.println("   - Result for ID 100: " + result2);
        System.out.println("   - Result for ID 999: " + result3);
        
        // ASSERT: Verify all calls return the stubbed value
        System.out.println("📌 ASSERT: Verifying results");
        assertEquals("Generic User Data", result1);
        assertEquals("Generic User Data", result2);
        assertEquals("Generic User Data", result3);
        System.out.println("   - ✅ All returned the same stubbed value");
        
        // Verify that the method was called 3 times
        verify(mockApi, times(3)).getUserData(anyInt());
        System.out.println("   - ✅ getUserData called 3 times");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testArgumentMatchers_SpecificValue_ShouldMatchExactly() {
        System.out.println("\n📝 Testing: testArgumentMatchers_SpecificValue_ShouldMatchExactly");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Stub specific and generic responses
        System.out.println("📌 ARRANGE: Stubbing different responses");
        when(mockApi.getUserData(eq(1))).thenReturn("User 1: Special");
        when(mockApi.getUserData(anyInt())).thenReturn("Generic User");
        
        // ACT: Call with different arguments
        System.out.println("📌 ACT: Calling with different user IDs");
        String result1 = service.fetchUserData(1);
        String result2 = service.fetchUserData(5);
        System.out.println("   - Result for ID 1: " + result1);
        System.out.println("   - Result for ID 5: " + result2);
        
        // ASSERT: Verify specific and generic stubs work
        System.out.println("📌 ASSERT: Verifying results");
        assertEquals("User 1: Special", result1);
        assertEquals("Generic User", result2);
        System.out.println("   - ✅ Specific stub for ID 1 worked");
        System.out.println("   - ✅ Generic stub for ID 5 worked");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testArgumentMatchers_AnyString_ShouldMatchAnyString() {
        System.out.println("\n📝 Testing: testArgumentMatchers_AnyString_ShouldMatchAnyString");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Stub with anyString()
        System.out.println("📌 ARRANGE: Stubbing getUsersByStatus with anyString()");
        when(mockApi.getUsersByStatus(anyString())).thenReturn(new String[]{"User1", "User2"});
        
        // ACT: Call with different status values
        System.out.println("📌 ACT: Calling with different status values");
        String[] activeUsers = mockApi.getUsersByStatus("active");
        String[] inactiveUsers = mockApi.getUsersByStatus("inactive");
        System.out.println("   - Active users: " + activeUsers.length + " found");
        System.out.println("   - Inactive users: " + inactiveUsers.length + " found");
        
        // ASSERT: Verify both return the stubbed array
        System.out.println("📌 ASSERT: Verifying results");
        assertEquals(2, activeUsers.length);
        assertEquals(2, inactiveUsers.length);
        System.out.println("   - ✅ Both returned the same stubbed array");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testArgumentMatchers_WithVerification() {
        System.out.println("\n📝 Testing: testArgumentMatchers_WithVerification");
        System.out.println("---------------------------------------------");
        
        // ACT: Call the service with different arguments
        System.out.println("📌 ACT: Calling methods with different arguments");
        service.fetchUserData(1);
        service.fetchUserData(2);
        service.fetchUserData(3);
        
        // ASSERT: Verify with argument matchers
        System.out.println("📌 ASSERT: Verifying with argument matchers");
        verify(mockApi, times(3)).getUserData(anyInt());
        System.out.println("   - ✅ Called with anyInt() 3 times");
        
        verify(mockApi).getUserData(1);
        System.out.println("   - ✅ Called with specific ID 1");
        
        verify(mockApi, atLeastOnce()).getUserData(anyInt());
        System.out.println("   - ✅ Called at least once with anyInt()");
        System.out.println("---------------------------------------------");
    }
}