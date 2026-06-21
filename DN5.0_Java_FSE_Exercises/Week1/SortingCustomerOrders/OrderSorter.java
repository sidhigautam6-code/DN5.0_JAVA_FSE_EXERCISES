package Week1.SortingCustomerOrders;
// src/OrderSorter.java
import java.util.Arrays;

public class OrderSorter {
    
    // Bubble Sort Implementation - O(n²)
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        long startTime = System.nanoTime();
        int comparisons = 0;
        int swaps = 0;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                    swaps++;
                }
            }
            
            // If no swapping occurred, array is already sorted
            if (!swapped) {
                break;
            }
        }
        
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort: " + comparisons + " comparisons, " + 
                          swaps + " swaps, Time: " + (endTime - startTime) + " ns");
    }
    
    // Quick Sort Implementation - O(n log n) average
    public static void quickSort(Order[] orders, int low, int high) {
        long startTime = System.nanoTime();
        
        if (low < high) {
            int pi = partition(orders, low, high);
            
            // Recursively sort elements before and after partition
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
        
        if (low == 0 && high == orders.length - 1) {
            long endTime = System.nanoTime();
            System.out.println("Quick Sort completed in: " + 
                              (endTime - startTime) + " ns");
        }
    }
    
    private static int partition(Order[] orders, int low, int high) {
        // Choose pivot as middle element for better performance
        int mid = low + (high - low) / 2;
        double pivot = orders[mid].getTotalPrice();
        
        // Move pivot to end
        swap(orders, mid, high);
        
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                swap(orders, i, j);
            }
        }
        
        // Move pivot to correct position
        swap(orders, i + 1, high);
        return i + 1;
    }
    
    private static void swap(Order[] orders, int i, int j) {
        Order temp = orders[i];
        orders[i] = orders[j];
        orders[j] = temp;
    }
    
    // Utility method to compare sorting algorithms
    public static void compareSortingAlgorithms(Order[] orders) {
        System.out.println("=== Sorting Algorithm Comparison ===\n");
        System.out.println("Number of orders: " + orders.length);
        
        // Bubble Sort (copy array to avoid affecting original)
        Order[] bubbleOrders = orders.clone();
        System.out.println("\n--- Bubble Sort ---");
        bubbleSort(bubbleOrders);
        
        // Quick Sort (copy array)
        Order[] quickOrders = orders.clone();
        System.out.println("\n--- Quick Sort ---");
        quickSort(quickOrders, 0, quickOrders.length - 1);
        
        // Show sorted results (first 5 and last 5)
        System.out.println("\n--- Quick Sort Results ---");
        System.out.println("Top 5 highest value orders:");
        int n = quickOrders.length;
        for (int i = n - 1; i >= Math.max(0, n - 5); i--) {
            System.out.println(quickOrders[i]);
        }
        
        System.out.println("\nBottom 5 orders:");
        for (int i = 0; i < Math.min(5, n); i++) {
            System.out.println(quickOrders[i]);
        }
    }
}
