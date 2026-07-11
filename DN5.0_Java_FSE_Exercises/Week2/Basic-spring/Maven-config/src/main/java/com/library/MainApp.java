package com.library;

import com.library.controller.BookController;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("  LIBRARY MANAGEMENT APPLICATION");
        System.out.println("  Maven Project - Exercise 4");
        System.out.println("======================================");
        System.out.println();
        
        try {
            // Load the Spring application context
            System.out.println("Loading Spring Application Context...");
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            System.out.println("Application Context loaded successfully!");
            System.out.println();
            
            // Get the BookController bean from the context
            System.out.println("Retrieving BookController bean...");
            BookController controller = context.getBean("bookController", BookController.class);
            System.out.println("BookController bean retrieved successfully!");
            System.out.println();
            
            // Start the console application
            controller.startConsoleApp();
            
            System.out.println();
            System.out.println("======================================");
            System.out.println("APPLICATION EXECUTED SUCCESSFULLY!");
            System.out.println("======================================");
            
        } catch (Exception e) {
            System.err.println("Error occurred while running the application:");
            e.printStackTrace();
        }
    }
}
