package Week1.InventoryManagementSystem;
// src/TestInventory.java
public class TestInventory {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Fixed: Product constructor should match (String, String, int, double)
        manager.addProduct(new Product("P001", "Gaming Laptop", 10, 999.99));
        manager.addProduct(new Product("P002", "Office Laptop", 15, 799.99));
        manager.addProduct(new Product("P003", "Gaming Laptop", 5, 1299.99));

        manager.displayInventory();

        // Fixed: Update method should use correct parameter order
        manager.updateProduct("P001", "Gaming Laptop", 8, 1099.99);
        
        // Fixed: Find method should use correct syntax
        Product found = manager.findProduct("P002");
        if (found != null) {
            System.out.println("Found: " + found);
        }

        manager.deleteProduct("P003");
        manager.displayInventory();

        // Fixed: Get total inventory value correctly
        System.out.println("Total Inventory Value: $" + 
                          String.format("%.2f", manager.getTotalInventoryValue()));
    }
}
