package com.library.repository;

public class BookRepository {
    
    private String repositoryName = "Default Book Repository";
    
    public BookRepository() {
        System.out.println("BookRepository: Constructor called");
    }
    
    public String getRepositoryName() {
        return repositoryName;
    }
    
    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }
    
    public void saveBook(String bookTitle) {
        System.out.println("Book saved: " + bookTitle);
    }
    
    public String findBook(String bookId) {
        System.out.println("Searching for book with ID: " + bookId);
        return "Book found: " + bookId + " - Sample Book Title";
    }
    
    public void getAllBooks() {
        System.out.println("Fetching all books from repository...");
    }
}
