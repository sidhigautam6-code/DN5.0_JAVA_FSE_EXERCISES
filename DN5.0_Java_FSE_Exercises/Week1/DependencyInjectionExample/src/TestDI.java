package Week1.DependencyInjectionExample.src;
// src/TestDI.java
public class TestDI {
    public static void main(String[] args) {
        System.out.println("=== DEPENDENCY INJECTION DEMONSTRATION ===\n");
        
        // Step 1: Configure database connection
        System.out.println("Step 1: Setting up database configuration");
        DatabaseConfig config = DatabaseConfig.getInstance();
        config.connect();
        
        // Step 2: Create the repository (dependency)
        System.out.println("\nStep 2: Creating repository");
        CustomerRepository repository = new CustomerRepositoryImpl();
        
        // Step 3: Inject the repository into the service (Dependency Injection)
        System.out.println("\nStep 3: Injecting dependency into service");
        CustomerService service = new CustomerService(repository);
        service.setServiceName("Premium Customer Service v2.0");
        
        // Step 4: Use the service
        System.out.println("\n=== Step 4: Using the service to perform operations ===\n");
        
        // Test 1: Find a single customer
        System.out.println("--- Test 1: Find Customer by ID ---");
        service.displayCustomerDetails("C001");
        
        // Test 2: Display all customers
        System.out.println("\n--- Test 2: Display All Customers ---");
        service.displayAllCustomers();
        
        // Test 3: Add a new customer
        System.out.println("\n--- Test 3: Add New Customer ---");
        service.addNewCustomer("Charlie Brown", "charlie@email.com", 
                               "+9988776655", "789 Maple Street, TX");
        
        // Test 4: Display all customers after addition
        System.out.println("\n--- Test 4: Display Customers After Addition ---");
        service.displayAllCustomers();
        
        // Test 5: Delete a customer
        System.out.println("\n--- Test 5: Delete Customer ---");
        service.deleteCustomer("C003");
        
        // Test 6: Display all customers after deletion
        System.out.println("\n--- Test 6: Display Customers After Deletion ---");
        service.displayAllCustomers();
        
        // Test 7: Try to find a non-existent customer
        System.out.println("\n--- Test 7: Find Non-existent Customer ---");
        service.displayCustomerDetails("C999");
        
        // Alternative demonstration: Manual dependency management
        System.out.println("\n=== Alternative Approach: Manual Dependency Management ===\n");
        demoManualDependencyManagement();
        
        // Step 5: Clean up
        System.out.println("\n=== Clean Up ===");
        config.disconnect();
    }
    
    private static void demoManualDependencyManagement() {
        System.out.println("Creating repository and service manually:");
        CustomerRepository manualRepo = new CustomerRepositoryImpl();
        CustomerService manualService = new CustomerService(manualRepo);
        manualService.setServiceName("Manual Service");
        
        System.out.println("\nFinding customer using manual dependency:");
        manualService.displayCustomerDetails("C002");
    }
}
