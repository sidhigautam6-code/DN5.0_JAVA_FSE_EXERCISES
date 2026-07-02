package com.library;

import com.library.service.BookService;
import com.library.service.repository.BookRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    
    public static void main(String[] args) {
        // Load Spring Context from XML
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("=========================================");
        System.out.println("Exercise 1: Basic Spring Application");
        System.out.println("=========================================");
        
        // Get BookService Bean
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook("Spring Framework Guide");
        bookService.getBook("B001");
        
        // Get BookRepository Bean
        BookRepository bookRepository = context.getBean("bookRepository", BookRepository.class);
        bookRepository.saveBook("Mastering Spring");
        bookRepository.findBook("B002");
        
        System.out.println("\n✅ Spring Configuration Test Completed Successfully!");
        System.out.println("=========================================");
    }
}