package com.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class InteractionOrderTest {
    
    private DatabaseConnection mockDb;
    private EmailService mockEmail;
    private UserService userService;
    
    @Before
    public void setUp() {
        System.out.println("🔧 Setting up Interaction Order test...");
        mockDb = mock(DatabaseConnection.class);
        mockEmail = mock(EmailService.class);
        userService = new UserService(mockDb, mockEmail);
    }
    
    @After
    public void tearDown() {
        System.out.println("🧹 Cleaning up test...");
    }
    
    // ===== EXERCISE 6: Verifying Interaction Order =====
    
    @Test
    public void testInteractionOrder_CreateUser_CorrectOrder() {
        System.out.println("\n📝 Testing: testInteractionOrder_CreateUser_CorrectOrder");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Setup mock stubs
        System.out.println("📌 ARRANGE: Stubbing saveUser to return true");
        when(mockDb.saveUser("alice", "alice@example.com")).thenReturn(true);
        
        // ACT: Call the method
        System.out.println("📌 ACT: Creating user");
        userService.createUser("alice", "alice@example.com");
        System.out.println("   - User created");
        
        // ASSERT: Verify order of interactions
        System.out.println("📌 ASSERT: Verifying interaction order");
        InOrder inOrder = inOrder(mockDb, mockEmail);
        
        // First: saveUser should be called
        inOrder.verify(mockDb).saveUser("alice", "alice@example.com");
        System.out.println("   - ✅ First: saveUser called");
        
        // Second: sendWelcomeEmail should be called
        inOrder.verify(mockEmail).sendWelcomeEmail("alice@example.com", "alice");
        System.out.println("   - ✅ Second: sendWelcomeEmail called");
        
        // Verify no more interactions
        inOrder.verifyNoMoreInteractions();
        System.out.println("   - ✅ No more interactions");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testInteractionOrder_DeleteUser_CorrectOrder() {
        System.out.println("\n📝 Testing: testInteractionOrder_DeleteUser_CorrectOrder");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Setup mock stubs
        System.out.println("📌 ARRANGE: Stubbing deleteUser to return true");
        when(mockDb.deleteUser("bob")).thenReturn(true);
        
        // ACT: Call the method
        System.out.println("📌 ACT: Deleting user");
        userService.deleteUser("bob");
        System.out.println("   - User deleted");
        
        // ASSERT: Verify order of interactions
        System.out.println("📌 ASSERT: Verifying interaction order");
        InOrder inOrder = inOrder(mockDb, mockEmail);
        
        // First: deleteUser should be called
        inOrder.verify(mockDb).deleteUser("bob");
        System.out.println("   - ✅ First: deleteUser called");
        
        // Second: sendDeletionNotification should be called
        inOrder.verify(mockEmail).sendDeletionNotification("bob");
        System.out.println("   - ✅ Second: sendDeletionNotification called");
        System.out.println("---------------------------------------------");
    }
    
    @Test
    public void testInteractionOrder_OnlyDatabaseCalls_NoEmailForNonExistentUser() {
        System.out.println("\n📝 Testing: testInteractionOrder_OnlyDatabaseCalls_NoEmailForNonExistentUser");
        System.out.println("---------------------------------------------");
        
        // ARRANGE: Setup mock stubs
        System.out.println("📌 ARRANGE: Stubbing deleteUser to return false");
        when(mockDb.deleteUser("bob")).thenReturn(false);
        
        // ACT: Call the method
        System.out.println("📌 ACT: Deleting non-existent user");
        userService.deleteUser("bob");
        System.out.println("   - User deletion attempted (not found)");
        
        // ASSERT: Verify only database interaction occurred
        System.out.println("📌 ASSERT: Verifying only database interaction");
        
        // Verify deleteUser was called
        verify(mockDb).deleteUser("bob");
        System.out.println("   - ✅ deleteUser called");
        
        // Verify email was NOT called
        verify(mockEmail, never()).sendDeletionNotification(anyString());
        System.out.println("   - ✅ sendDeletionNotification NOT called");
        System.out.println("---------------------------------------------");
    }
}