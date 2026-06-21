package src;
// src/SearchEngine.java
import java.util.*;

public class SearchEngine {
    private Product[] products;
    private int size;
    
    public SearchEngine(Product[] products) {
        this.products = products;
        this.size = products.length;
    }
    
    // Linear Search - O(n)
    public Product linearSearchByName(String productName) {
        if (productName == null || productName.isEmpty()) {
            return null;
        }
        
        long startTime = System.nanoTime();
        
        for (int i = 0; i < size; i++) {
            if (products[i].getProductName().equalsIgnoreCase(productName)) {
                long endTime = System.nanoTime();
                System.out.println("Linear Search time: " + (endTime - startTime) + " ns");
                return products[i];
            }
        }
        
        long endTime = System.nanoTime();
        System.out.println("Linear Search time: " + (endTime - startTime) + " ns");
        return null;
    }
    
    // Binary Search - O(log n) - assumes sorted array
    public Product binarySearchByName(String productName) {
        if (productName == null || productName.isEmpty() || !isSorted()) {
            return null;
        }
        
        long startTime = System.nanoTime();
        
        int left = 0;
        int right = size - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName()
                             .compareToIgnoreCase(productName);
            
            if (comparison == 0) {
                long endTime = System.nanoTime();
                System.out.println("Binary Search time: " + (endTime - startTime) + " ns");
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        long endTime = System.nanoTime();
        System.out.println("Binary Search time: " + (endTime - startTime) + " ns");
        return null;
    }
    
    // Sort products by name for binary search
    public void sortProductsByName() {
        // Using Arrays.sort with custom comparator
        Arrays.sort(products, 0, size, 
                    (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));
        System.out.println("Products sorted by name for binary search");
    }
    
    private boolean isSorted() {
        for (int i = 0; i < size - 1; i++) {
            if (products[i].getProductName()
                .compareToIgnoreCase(products[i+1].getProductName()) > 0) {
                return false;
            }
        }
        return true;
    }
    
    // Multiple search performance comparison
    public void compareSearchPerformance(String productName) {
        System.out.println("\n=== Search Performance Comparison ===");
        System.out.println("Searching for: " + productName);
        
        // Linear Search
        Product result1 = linearSearchByName(productName);
        if (result1 != null) {
            System.out.println("Found using Linear Search: " + result1);
        } else {
            System.out.println("Not found using Linear Search");
        }
        
        // Binary Search (requires sorted array)
        sortProductsByName();
        Product result2 = binarySearchByName(productName);
        if (result2 != null) {
            System.out.println("Found using Binary Search: " + result2);
        } else {
            System.out.println("Not found using Binary Search");
        }
        
        System.out.println("========================================\n");
    }
}
