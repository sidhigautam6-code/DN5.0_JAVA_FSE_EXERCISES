package Week1.LibraryManagementSystem.src;
// src/LibrarySearch.java
import java.util.*;

public class LibrarySearch {
    private Book[] books;
    private int size;
    
    public LibrarySearch(Book[] books) {
        this.books = books.clone();
        this.size = this.books.length;
    }
    
    // Linear Search by Title - O(n)
    public Book linearSearchByTitle(String title) {
        if (title == null || title.isEmpty()) {
            System.out.println("Invalid title");
            return null;
        }
        
        long startTime = System.nanoTime();
        int comparisons = 0;
        
        for (int i = 0; i < size; i++) {
            comparisons++;
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                long endTime = System.nanoTime();
                System.out.println("Linear Search: " + comparisons + " comparisons, " +
                                  "Time: " + (endTime - startTime) + " ns");
                return books[i];
            }
        }
        
        long endTime = System.nanoTime();
        System.out.println("Linear Search: " + comparisons + " comparisons, " +
                          "Time: " + (endTime - startTime) + " ns (not found)");
        return null;
    }
    
    // Linear Search by Author - O(n)
    public Book[] linearSearchByAuthor(String author) {
        if (author == null || author.isEmpty()) {
            return new Book[0];
        }
        
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                count++;
            }
        }
        
        Book[] results = new Book[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                results[index++] = books[i];
            }
        }
        
        return results;
    }
    
    // Binary Search by Title - O(log n)
    public Book binarySearchByTitle(String title) {
        if (title == null || title.isEmpty()) {
            System.out.println("Invalid title");
            return null;
        }
        
        // Ensure books are sorted by title
        if (!isSortedByTitle()) {
            sortBooksByTitle();
        }
        
        long startTime = System.nanoTime();
        int comparisons = 0;
        
        int left = 0;
        int right = size - 1;
        
        while (left <= right) {
            comparisons++;
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            
            if (comparison == 0) {
                long endTime = System.nanoTime();
                System.out.println("Binary Search: " + comparisons + " comparisons, " +
                                  "Time: " + (endTime - startTime) + " ns");
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        long endTime = System.nanoTime();
        System.out.println("Binary Search: " + comparisons + " comparisons, " +
                          "Time: " + (endTime - startTime) + " ns (not found)");
        return null;
    }
    
    // Sort books by title
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, 
                    (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        System.out.println("Books sorted by title");
    }
    
    private boolean isSortedByTitle() {
        for (int i = 0; i < size - 1; i++) {
            if (books[i].getTitle().compareToIgnoreCase(books[i+1].getTitle()) > 0) {
                return false;
            }
        }
        return true;
    }
    
    // Compare search performance
    public void compareSearchPerformance(String title) {
        System.out.println("\n=== Search Performance Comparison ===");
        System.out.println("Searching for: " + title);
        
        // Linear Search (unsorted)
        System.out.println("\n--- Linear Search (Unsorted) ---");
        Book result1 = linearSearchByTitle(title);
        if (result1 != null) System.out.println("Found: " + result1);
        
        // Sort for binary search
        sortBooksByTitle();
        
        // Binary Search
        System.out.println("\n--- Binary Search (Sorted) ---");
        Book result2 = binarySearchByTitle(title);
        if (result2 != null) System.out.println("Found: " + result2);
        
        System.out.println("================================\n");
    }
    
    // Get all books
    public Book[] getAllBooks() {
        return Arrays.copyOf(books, size);
    }
    
    // Get books by availability
    public Book[] getAvailableBooks() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].isAvailable()) count++;
        }
        
        Book[] available = new Book[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].isAvailable()) {
                available[index++] = books[i];
            }
        }
        return available;
    }
}
