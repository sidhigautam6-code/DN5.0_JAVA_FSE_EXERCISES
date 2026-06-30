package com.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.mockito.Mockito.*;

public class VoidMethodTest {
    
    private ExternalApi mockApi;
    private MyService service;
    private EmailService mockEmail;
    
    @Before
    public void setUp() {
        System.out.println("🔧 Setting up Void Method test...");
        mockApi = mock(ExternalApi.class);
        mockEmail = mock(EmailService.class);
        service = new MyService(mockApi);
    }
    
    @After
    public void tearDown() {
        System.out.println("🧹 Cleaning up test...");
    }
    
    // ===== EXERCISE 4: Handling Void Methods =====
    
    @Test
    public void testVoidMethod_VerifySaveData_CalledOnce() {
        System.out.println("\n📝 Testing: testVoidMethod_VerifySaveData_CalledOnce");
        System.out.println("---------------------------------------------");
        
        // ACT: Call a void method
        System.out.println("📌 ACT: Calling service.saveData()");
        service.saveData("Test Data");
        System.out.println("   - Called saveData with 'Test Data'");
        
        // ASSERT: Verify void method was called
        System.out.println("📌 ASSERT: Verifying void method was called");
        verify(mockApi, times(1)).saveData("Test Data");
        System.out.println("   - ✅ saveData was called once with correct argument");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testVoidMethod_VerifyEmailSend_CalledOnce() {
        System.out.println("\n📝 Testing: testVoidMethod_VerifyEmailSend_CalledOnce");
        System.out.println("---------------------------------------------");
        
        // ACT: Send welcome email
        System.out.println("📌 ACT: Sending welcome email");
        mockEmail.sendWelcomeEmail("test@example.com", "TestUser");
        System.out.println("   - Email sent to test@example.com");
        
        // ASSERT: Verify void method was called
        System.out.println("📌 ASSERT: Verifying email was sent");
        verify(mockEmail, times(1)).sendWelcomeEmail("test@example.com", "TestUser");
        System.out.println("   - ✅ sendWelcomeEmail called once");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testVoidMethod_MultipleCalls_VerifyCount() {
        System.out.println("\n📝 Testing: testVoidMethod_MultipleCalls_VerifyCount");
        System.out.println("---------------------------------------------");
        
        // ACT: Call void method multiple times
        System.out.println("📌 ACT: Calling saveData multiple times");
        service.saveData("Data 1");
        service.saveData("Data 2");
        service.saveData("Data 3");
        System.out.println("   - Called saveData 3 times");
        
        // ASSERT: Verify number of calls
        System.out.println("📌 ASSERT: Verifying call count");
        verify(mockApi, times(3)).saveData(anyString());
        System.out.println("   - ✅ saveData called exactly 3 times");
        verify(mockApi, atLeast(2)).saveData(anyString());
        System.out.println("   - ✅ saveData called at least 2 times");
        verify(mockApi, atMost(3)).saveData(anyString());
        System.out.println("   - ✅ saveData called at most 3 times");
        System.out.println("---------------------------------------------");
    }
    
    // ===== EXERCISE 7: Void Methods with Exceptions =====
    
    @Test
    public void testVoidMethod_WithException_ShouldThrowException() {
        System.out.println("\n📝 Testing: testVoidMethod_WithException_ShouldThrowException");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Stub void method to throw exception
        System.out.println("📌 ARRANGE: Stubbing void method to throw exception");
        doThrow(new RuntimeException("API Error occurred"))
            .when(mockApi).saveData(anyString());
        
        // ACT & ASSERT: Verify exception is thrown
        System.out.println("📌 ACT & ASSERT: Calling saveData with exception");
        try {
            service.saveData("Test Data");
            fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException e) {
            System.out.println("   - ✅ Exception caught: " + e.getMessage());
        }
        
        // Verify the method was called
        verify(mockApi, times(1)).saveData("Test Data");
        System.out.println("   - ✅ saveData was called once");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testVoidMethod_WithException_DoNothingWhenNotThrowing() {
        System.out.println("\n📝 Testing: testVoidMethod_WithException_DoNothingWhenNotThrowing");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Use doNothing() for void method (default)
        System.out.println("📌 ARRANGE: Stubbing saveData to doNothing()");
        doNothing().when(mockApi).saveData(anyString());
        
        // ACT: Call method (should not throw)
        System.out.println("📌 ACT: Calling saveData (should not throw)");
        service.saveData("Test Data");
        System.out.println("   - Called saveData successfully");
        
        // ASSERT: Verify method was called
        System.out.println("📌 ASSERT: Verifying method was called");
        verify(mockApi, times(1)).saveData("Test Data");
        System.out.println("   - ✅ saveData was called once without exception");
        System.out.println("---------------------------------------------");
    }
}