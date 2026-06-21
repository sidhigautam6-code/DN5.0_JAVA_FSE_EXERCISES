package Week1.LibraryManagementSystem.src;
// src/Book.java
public class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private int yearPublished;
    private boolean available;
    
    public Book(String bookId, String title, String author, 
                String isbn, int yearPublished, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.yearPublished = yearPublished;
        this.available = available;
    }
    
    // Getters
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getYearPublished() { return yearPublished; }
    public boolean isAvailable() { return available; }
    
    // Setters
    public void setAvailable(boolean available) { this.available = available; }
    
    @Override
    public String toString() {
        return String.format("Book[ID: %s, Title: %s, Author: %s, " +
                           "ISBN: %s, Year: %d, Available: %s]",
                           bookId, title, author, isbn, yearPublished, 
                           available ? "Yes" : "No");
    }
}
