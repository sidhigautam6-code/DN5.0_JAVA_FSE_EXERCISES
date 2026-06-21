package Week1.SingletonPatternExample;
// src/Logger.java
public class Logger {
    // Private static instance of itself (Eager initialization)
    private static Logger instance = new Logger();
    
    // Private constructor to prevent instantiation
    private Logger() {
        System.out.println("Logger instance created");
    }
    
    // Public static method to get the instance
    public static Logger getInstance() {
        return instance;
    }
    
    // Example logging method
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
