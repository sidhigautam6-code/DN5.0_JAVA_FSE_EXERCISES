package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Simulates an external API service.
 * This is the class we will mock in our tests.
 */
public class ExternalApi {
    
    private Map<Integer, String> userDatabase = new HashMap<>();
    
    public ExternalApi() {
        // Initialize with some sample data
        userDatabase.put(1, "John Doe");
        userDatabase.put(2, "Jane Smith");
        userDatabase.put(3, "Bob Johnson");
    }
    
    /**
     * Fetches data from the external API.
     * @return data as a String
     */
    public String getData() {
        // In real implementation, this would make an HTTP call
        return "Real Data from API";
    }
    
    /**
     * Fetches user data by ID.
     * @param userId the user ID
     * @return user data as a String
     * @throws IllegalArgumentException if userId is invalid
     */
    public String getUserData(int userId) {
        if (userId < 1) {
            throw new IllegalArgumentException("Invalid user ID: " + userId);
        }
        return userDatabase.getOrDefault(userId, "User not found");
    }
    
    /**
     * Saves data to the external system.
     * @param data the data to save
     */
    public void saveData(String data) {
        System.out.println("Saving to external API: " + data);
    }
    
    /**
     * Checks if the API is healthy.
     * @return true if healthy, false otherwise
     */
    public boolean isHealthy() {
        return true;
    }
    
    /**
     * Gets a list of users from the API.
     * @return array of user names
     */
    public String[] getUsers() {
        return new String[]{"Alice", "Bob", "Charlie", "David"};
    }
    
    /**
     * Gets a list of users based on status.
     * @param status the user status
     * @return array of user names
     */
    public String[] getUsersByStatus(String status) {
        if ("active".equals(status)) {
            return new String[]{"Alice", "Bob", "Charlie"};
        }
        return new String[]{"David"};
    }
}