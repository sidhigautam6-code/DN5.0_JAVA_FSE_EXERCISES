package com.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    
    private DatabaseConnection mockDb;
    private EmailService mockEmail;
    private UserService userService;
    
    @Before
    public void setUp() {
        System.out.println("🔧 Setting up UserService test...");
        mockDb = mock(DatabaseConnection.class);
        mockEmail = mock(EmailService.class);
        userService = new UserService(mockDb, mockEmail);
    }
    
    @After
    public void tearDown() {
        System.out.println("🧹 Cleaning up test...");
    }
    
    // ===== EXERCISE 2: Verifying Interactions =====
    
    @Test
    public void testVerifyInteraction_SaveUser_SavesToDatabaseAndSendsEmail() {
        System.out.println("\n📝 Testing: testVerifyInteraction_SaveUser_SavesToDatabaseAndSendsEmail");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Setup mock stubs
        System.out.println("📌 ARRANGE: Stubbing saveUser to return true");
        when(mockDb.saveUser("alice", "alice@example.com")).thenReturn(true);
        
        // ACT: Call the method
        System.out.println("📌 ACT: Creating user alice");
        boolean result = userService.createUser("alice", "alice@example.com");
        System.out.println("   - Result: " + result);
        
        // ASSERT: Verify interactions
        System.out.println("📌 ASSERT: Verifying interactions");
        
        // Verify saveUser was called exactly once with correct arguments
        verify(mockDb, times(1)).saveUser("alice", "alice@example.com");
        System.out.println("   - ✅ saveUser called once");
        
        // Verify sendWelcomeEmail was called exactly once with correct arguments
        verify(mockEmail, times(1)).sendWelcomeEmail("alice@example.com", "alice");
        System.out.println("   - ✅ sendWelcomeEmail called once");
        
        // Verify no other interactions occurred
        verifyNoMoreInteractions(mockDb, mockEmail);
        System.out.println("   - ✅ No unexpected interactions");
        
        assertTrue(result);
        System.out.println("   - ✅ Test passed!");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testVerifyInteraction_UserExists_ShouldCallDatabaseOnly() {
        System.out.println("\n📝 Testing: testVerifyInteraction_UserExists_ShouldCallDatabaseOnly");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Setup mock stubs
        System.out.println("📌 ARRANGE: Stubbing userExists to return true");
        when(mockDb.userExists("bob")).thenReturn(true);
        
        // ACT: Call the method
        System.out.println("📌 ACT: Checking if bob exists");
        boolean result = userService.userExists("bob");
        System.out.println("   - Result: " + result);
        
        // ASSERT: Verify interactions
        System.out.println("📌 ASSERT: Verifying interactions");
        verify(mockDb, times(1)).userExists("bob");
        System.out.println("   - ✅ userExists called once");
        
        // Verify email service was NOT called
        verify(mockEmail, never()).sendWelcomeEmail(anyString(), anyString());
        System.out.println("   - ✅ Email service not called as expected");
        
        assertTrue(result);
        System.out.println("   - ✅ Test passed!");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testVerifyInteraction_DeleteUser_SendsDeletionEmail() {
        System.out.println("\n📝 Testing: testVerifyInteraction_DeleteUser_SendsDeletionEmail");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Setup mock stubs
        System.out.println("📌 ARRANGE: Stubbing deleteUser to return true");
        when(mockDb.deleteUser("charlie")).thenReturn(true);
        
        // ACT: Call the method
        System.out.println("📌 ACT: Deleting user charlie");
        boolean result = userService.deleteUser("charlie");
        System.out.println("   - Result: " + result);
        
        // ASSERT: Verify interactions
        System.out.println("📌 ASSERT: Verifying interactions");
        verify(mockDb, times(1)).deleteUser("charlie");
        System.out.println("   - ✅ deleteUser called once");
        verify(mockEmail, times(1)).sendDeletionNotification("charlie");
        System.out.println("   - ✅ sendDeletionNotification called once");
        
        assertTrue(result);
        System.out.println("   - ✅ Test passed!");
        System.out.println("---------------------------------------------");
    }
}