package Week1.DependencyInjectionExample.src;
// src/DatabaseConfig.java
public class DatabaseConfig {
    private static DatabaseConfig instance;
    private String databaseUrl;
    private String username;
    private String password;
    private boolean isConnected;
    
    private DatabaseConfig() {
        // Initialize with default values
        this.databaseUrl = "jdbc:mysql://localhost:3306/customer_db";
        this.username = "admin";
        this.password = "password123";
        this.isConnected = false;
    }
    
    public static DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }
    
    public void connect() {
        if (!isConnected) {
            System.out.println("Connecting to database: " + databaseUrl);
            System.out.println("Using username: " + username);
            isConnected = true;
            System.out.println("Connected successfully!");
        } else {
            System.out.println("Already connected to database");
        }
    }
    
    public void disconnect() {
        if (isConnected) {
            System.out.println("Disconnecting from database...");
            isConnected = false;
            System.out.println("Disconnected successfully");
        }
    }
    
    public boolean isConnected() {
        return isConnected;
    }
    
    // Getters and Setters
    public String getDatabaseUrl() { return databaseUrl; }
    public String getUsername() { return username; }
    public void setDatabaseUrl(String url) { this.databaseUrl = url; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
}
