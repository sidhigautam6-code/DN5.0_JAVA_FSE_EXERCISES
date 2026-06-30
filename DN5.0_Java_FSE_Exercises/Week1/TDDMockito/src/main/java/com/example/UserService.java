package com.example;

/**
 * A service for managing users.
 */
public class UserService {
    
    private DatabaseConnection dbConnection;
    private EmailService emailService;
    
    public UserService(DatabaseConnection dbConnection, EmailService emailService) {
        this.dbConnection = dbConnection;
        this.emailService = emailService;
    }
    
    /**
     * Creates a new user.
     * @param username the username
     * @param email the email
     * @return true if user was created successfully
     */
    public boolean createUser(String username, String email) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        
        // Save user to database
        boolean saved = dbConnection.saveUser(username, email);
        
        if (saved) {
            // Send welcome email
            emailService.sendWelcomeEmail(email, username);
            return true;
        }
        
        return false;
    }
    
    /**
     * Deletes a user.
     * @param username the username to delete
     * @return true if deleted successfully
     */
    public boolean deleteUser(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        
        boolean deleted = dbConnection.deleteUser(username);
        
        if (deleted) {
            // Send notification
            emailService.sendDeletionNotification(username);
        }
        
        return deleted;
    }
    
    /**
     * Checks if a user exists.
     * @param username the username
     * @return true if user exists
     */
    public boolean userExists(String username) {
        return dbConnection.userExists(username);
    }
}