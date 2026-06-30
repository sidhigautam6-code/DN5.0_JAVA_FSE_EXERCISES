package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Simulates a database connection.
 */
public class DatabaseConnection {
    
    private Map<String, String> userDatabase = new HashMap<>();
    
    public DatabaseConnection() {
        userDatabase.put("alice", "alice@example.com");
        userDatabase.put("bob", "bob@example.com");
        userDatabase.put("charlie", "charlie@example.com");
    }
    
    /**
     * Saves a user to the database.
     * @param username the username
     * @param email the email
     * @return true if saved successfully
     */
    public boolean saveUser(String username, String email) {
        if (userDatabase.containsKey(username)) {
            return false; // User already exists
        }
        userDatabase.put(username, email);
        return true;
    }
    
    /**
     * Deletes a user from the database.
     * @param username the username to delete
     * @return true if deleted successfully
     */
    public boolean deleteUser(String username) {
        if (!userDatabase.containsKey(username)) {
            return false;
        }
        userDatabase.remove(username);
        return true;
    }
    
    /**
     * Checks if a user exists.
     * @param username the username
     * @return true if user exists
     */
    public boolean userExists(String username) {
        return userDatabase.containsKey(username);
    }
    
    /**
     * Gets email for a user.
     * @param username the username
     * @return email address
     */
    public String getUserEmail(String username) {
        return userDatabase.get(username);
    }
}