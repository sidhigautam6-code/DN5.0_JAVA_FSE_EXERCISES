package Week1.SingletonPatternExample;
// src/TestSingleton.java
public class TestSingleton {
    public static void main(String[] args) {
        // Get the singleton instance
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        // Check if both references point to the same instance
        System.out.println("Are both instances same? " + (logger1 == logger2));
        
        // Test logging
        logger1.log("Application started");
        logger2.log("Application ending");
        
        // Verify hashcodes
        System.out.println("Logger1 hash: " + logger1.hashCode());
        System.out.println("Logger2 hash: " + logger2.hashCode());
    }
}

