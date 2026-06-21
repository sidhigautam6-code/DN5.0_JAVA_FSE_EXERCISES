package Week1.SortingCustomerOrders;
// src/TestSorting.java
import java.util.Random;

public class TestSorting {
    public static void main(String[] args) {
        System.out.println("=== SORTING CUSTOMER ORDERS ===\n");
        
        // Create sample orders
        Order[] orders = createSampleOrders();
        
        // Compare sorting algorithms
        OrderSorter.compareSortingAlgorithms(orders);
        
        // Performance analysis with different sizes
        System.out.println("\n=== Performance Analysis ===\n");
        analyzePerformance();
    }
    
    private static Order[] createSampleOrders() {
        return new Order[] {
            new Order("O001", "John Doe", 250.50, "2024-01-15"),
            new Order("O002", "Jane Smith", 150.75, "2024-01-16"),
            new Order("O003", "Bob Johnson", 500.00, "2024-01-17"),
            new Order("O004", "Alice Brown", 75.25, "2024-01-18"),
            new Order("O005", "Charlie Wilson", 350.00, "2024-01-19"),
            new Order("O006", "Diana Miller", 1200.00, "2024-01-20"),
            new Order("O007", "Eve Davis", 899.99, "2024-01-21"),
            new Order("O008", "Frank Garcia", 450.50, "2024-01-22"),
            new Order("O009", "Grace Lee", 675.00, "2024-01-23"),
            new Order("O010", "Henry Kim", 325.75, "2024-01-24")
        };
    }
    
    private static void analyzePerformance() {
        int[] sizes = {100, 1000, 5000, 10000};
        Random random = new Random();
        
        System.out.printf("%-10s %-20s %-20s%n", "Size", "Bubble Sort (ms)", "Quick Sort (ms)");
        System.out.println("--------------------------------------------------------------");
        
        for (int size : sizes) {
            Order[] orders = new Order[size];
            for (int i = 0; i < size; i++) {
                orders[i] = new Order(
                    "O" + i,
                    "Customer" + i,
                    100 + random.nextDouble() * 900,
                    "2024-01-15"
                );
            }
            
            // Bubble Sort timing
            Order[] bubbleOrders = orders.clone();
            long bubbleStart = System.nanoTime();
            OrderSorter.bubbleSort(bubbleOrders);
            long bubbleEnd = System.nanoTime();
            
            // Quick Sort timing
            Order[] quickOrders = orders.clone();
            long quickStart = System.nanoTime();
            OrderSorter.quickSort(quickOrders, 0, quickOrders.length - 1);
            long quickEnd = System.nanoTime();
            
            System.out.printf("%-10d %-20.2f %-20.2f%n", 
                            size,
                            (bubbleEnd - bubbleStart) / 1_000_000.0,
                            (quickEnd - quickStart) / 1_000_000.0);
        }
    }
}
