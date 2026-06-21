package Week1.InventoryManagementSystem;
// src/InventoryManager.java
import java.util.*;

public class InventoryManager {
    private Map<String, Product> inventory;
    
    public InventoryManager() {
        this.inventory = new HashMap<>();
    }
    
    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Cannot add null product");
            return;
        }
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product already exists. Use update method.");
            return;
        }
        inventory.put(product.getProductId(), product);
        System.out.println("Product added: " + product.getProductName());
    }
    
    public void updateProduct(String productId, String name, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product == null) {
            System.out.println("Product not found: " + productId);
            return;
        }
        if (name != null) product.setProductName(name);
        if (quantity >= 0) product.setQuantity(quantity);
        if (price >= 0) product.setPrice(price);
        System.out.println("Product updated: " + productId);
    }
    
    public void deleteProduct(String productId) {
        Product removed = inventory.remove(productId);
        if (removed != null) {
            System.out.println("Product deleted: " + removed.getProductName());
        } else {
            System.out.println("Product not found: " + productId);
        }
    }
    
    public Product findProduct(String productId) {
        Product product = inventory.get(productId);
        if (product == null) {
            System.out.println("Product not found: " + productId);
        }
        return product;
    }
    
    public List<Product> getAllProducts() {
        return new ArrayList<>(inventory.values());
    }
    
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty");
            return;
        }
        System.out.println("\n=== INVENTORY ===");
        System.out.println("Total products: " + inventory.size());
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
        System.out.println("================");
    }
    
    public double getTotalInventoryValue() {
        double total = 0.0;
        for (Product product : inventory.values()) {
            total += product.getQuantity() * product.getPrice();
        }
        return total;
    }
}
