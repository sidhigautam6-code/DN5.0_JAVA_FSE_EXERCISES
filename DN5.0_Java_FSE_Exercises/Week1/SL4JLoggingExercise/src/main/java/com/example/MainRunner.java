package com.example;

public class MainRunner {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("EXERCISE 1: Logging Error and Warning");
        System.out.println("=========================================");
        LoggingExample.main(args);
        
        System.out.println("\n=========================================");
        System.out.println("EXERCISE 2: Parameterized Logging");
        System.out.println("=========================================");
        ParameterizedLoggingExample.main(args);
        
        System.out.println("\n=========================================");
        System.out.println("EXERCISE 3: Using Different Appenders");
        System.out.println("=========================================");
        AppenderExample.main(args);
    }
}