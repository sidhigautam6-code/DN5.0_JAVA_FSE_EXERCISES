package Week1.LibraryManagementSystem.src;

import java.util.Random;

// src/TestLibrary.java
public class TestLibrary {
    public static void main(String[] args) {
        System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===\n");
        
        // Create sample books
        Book[] books = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", 
                    "978-0-7432-7356-5", 1925, true),
            new Book("B002", "To Kill a Mockingbird", "Harper Lee", 
                    "978-0-06-112008-4", 1960, true),
            new Book("B003", "1984", "George Orwell", 
                    "978-0-452-28423-4", 1949, false),
            new Book("B004", "Pride and Prejudice", "Jane Austen", 
                    "978-0-14-143951-8", 1813, true),
            new Book("B005", "The Catcher in the Rye", "J.D. Salinger", 
                    "978-0-316-76948-0", 1951, true),
            new Book("B006", "Brave New World", "Aldous Huxley", 
                    "978-0-06-085052-4", 1932, false),
            new Book("B007", "The Hobbit", "J.R.R. Tolkien", 
                    "978-0-547-92822-7", 1937, true)
        };
        
        LibrarySearch library = new LibrarySearch(books);
        
        // Test searches
        System.out.println("Test 1: Search existing book");
        library.compareSearchPerformance("1984");
        
        System.out.println("\nTest 2: Search non-existing book");
        library.compareSearchPerformance("Non-existent Book");
        
        System.out.println("\nTest 3: Case-insensitive search");
        library.compareSearchPerformance("the great gatsby");
        
        System.out.println("\nTest 4: Search by author");
        Book[] authorBooks = library.linearSearchByAuthor("J.R.R. Tolkien");
        System.out.println("Books by J.R.R. Tolkien:");
        for (Book b : authorBooks) {
            System.out.println("  " + b);
        }
        
        System.out.println("\nTest 5: Available books");
        Book[] available = library.getAvailableBooks();
        System.out.println("Available books (" + available.length + "):");
        for (Book b : available) {
            System.out.println("  " + b);
        }
        
        // Performance analysis with different sizes
        System.out.println("\n=== Performance Analysis ===\n");
        analyzePerformance();
    }
    
    private static void analyzePerformance() {
        int[] sizes = {100, 1000, 5000, 10000};
        Random random = new Random();
        
        System.out.printf("%-10s %-15s %-15s %-15s%n", 
                         "Size", "Linear (ns)", "Binary (ns)", "Speedup");
        System.out.println("------------------------------------------------------");
        
        for (int size : sizes) {
            Book[] books = new Book[size];
            for (int i = 0; i < size; i++) {
                books[i] = new Book(
                    "B" + i,
                    "Book " + i,
                    "Author " + (i % 20),
                    "ISBN" + i,
                    1900 + i % 100,
                    true
                );
            }
            
            LibrarySearch library = new LibrarySearch(books);
            String searchTitle = "Book " + (size / 2);
            
            // Linear search timing
            long linearStart = System.nanoTime();
            library.linearSearchByTitle(searchTitle);
            long linearEnd = System.nanoTime();
            
            // Binary search timing
            library.sortBooksByTitle();
            long binaryStart = System.nanoTime();
            library.binarySearchByTitle(searchTitle);
            long binaryEnd = System.nanoTime();
            
            long linearTime = linearEnd - linearStart;
            long binaryTime = binaryEnd - binaryStart;
            double speedup = (double) linearTime / binaryTime;
            
            System.out.printf("%-10d %-15d %-15d %-15.2fx%n", 
                            size, linearTime, binaryTime, speedup);
        }
    }
}
