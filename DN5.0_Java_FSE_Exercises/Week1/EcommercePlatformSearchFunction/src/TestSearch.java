package src;
// src/TestSearch.java
public class TestSearch {
    public static void main(String[] args) {
        System.out.println("=== E-COMMERCE SEARCH DEMONSTRATION ===\n");
        
        // Create sample products
        Product[] products = {
            new Product("P001", "iPhone 13", "Electronics", 799.99),
            new Product("P002", "Samsung Galaxy S21", "Electronics", 699.99),
            new Product("P003", "Sony Headphones", "Electronics", 199.99),
            new Product("P004", "Nike Running Shoes", "Sports", 129.99),
            new Product("P005", "Adidas T-Shirt", "Clothing", 29.99),
            new Product("P006", "Apple Watch", "Electronics", 399.99),
            new Product("P007", "Dell XPS Laptop", "Electronics", 1299.99),
            new Product("P008", "Levi's Jeans", "Clothing", 79.99)
        };
        
        SearchEngine searchEngine = new SearchEngine(products);
        
        // Test search for existing product
        System.out.println("Test 1: Search existing product");
        searchEngine.compareSearchPerformance("Sony Headphones");
        
        // Test search for non-existing product
        System.out.println("Test 2: Search non-existing product");
        searchEngine.compareSearchPerformance("Xiaomi Phone");
        
        // Additional tests
        System.out.println("Test 3: Search with different case");
        searchEngine.compareSearchPerformance("iphone 13");
        
        // Performance analysis with different sizes
        System.out.println("=== Performance Analysis ===");
        analyzePerformance();
    }
    
    private static void analyzePerformance() {
        // Create arrays of different sizes for performance comparison
        int[] sizes = {100, 1000, 10000, 100000};
        
        System.out.println("Size\tLinear Search\tBinary Search");
        System.out.println("----------------------------------------");
        
        for (int size : sizes) {
            // Create products array
            Product[] products = new Product[size];
            for (int i = 0; i < size; i++) {
                products[i] = new Product(
                    "P" + i,
                    "Product" + i,
                    "Category" + (i % 5),
                    i * 10.0
                );
            }
            
            SearchEngine engine = new SearchEngine(products);
            
            // Linear search timing
            long linearStart = System.nanoTime();
            engine.linearSearchByName("Product" + (size - 1));
            long linearEnd = System.nanoTime();
            
            // Binary search timing
            engine.sortProductsByName();
            long binaryStart = System.nanoTime();
            engine.binarySearchByName("Product" + (size - 1));
            long binaryEnd = System.nanoTime();
            
            System.out.printf("%d\t%d ns\t\t%d ns%n", 
                            size, 
                            (linearEnd - linearStart),
                            (binaryEnd - binaryStart));
        }
    }
}
