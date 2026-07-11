package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;
    private String serviceName = "Default Book Service";
    
    public BookService() {
        System.out.println("BookService: Constructor called");
    }
    
    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected via setter");
    }
    
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    public String getServiceName() {
        return serviceName;
    }
    
    public void addBook(String bookTitle) {
        System.out.println("BookService: Adding book - " + bookTitle);
        if (bookRepository != null) {
            bookRepository.saveBook(bookTitle);
        } else {
            System.out.println("ERROR: BookRepository is not injected!");
        }
    }
    
    public String getBook(String bookId) {
        System.out.println("BookService: Getting book with ID - " + bookId);
        if (bookRepository != null) {
            return bookRepository.findBook(bookId);
        } else {
            return "ERROR: BookRepository is not injected!";
        }
    }
    
    public void displayServiceInfo() {
        System.out.println("Service Name: " + serviceName);
        if (bookRepository != null) {
            System.out.println("Repository Name: " + bookRepository.getRepositoryName());
        } else {
            System.out.println("Repository: NOT SET");
        }
    }
}
