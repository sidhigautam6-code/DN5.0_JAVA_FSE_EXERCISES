package Week1.DependencyInjectionExample.src;
// src/CustomerRepositoryImpl.java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customerDatabase;
    private static int idCounter = 1000;
    
    public CustomerRepositoryImpl() {
        customerDatabase = new HashMap<>();
        // Initialize with dummy data
        initializeDummyData();
    }
    
    private void initializeDummyData() {
        Customer customer1 = new Customer("C001", "John Doe", "john@email.com", 
                                         "+1234567890", "123 Main St, NY");
        Customer customer2 = new Customer("C002", "Jane Smith", "jane@email.com", 
                                         "+9876543210", "456 Park Ave, LA");
        Customer customer3 = new Customer("C003", "Bob Johnson", "bob@email.com", 
                                         "+1122334455", "789 Oak Blvd, SF");
        Customer customer4 = new Customer("C004", "Alice Williams", "alice@email.com", 
                                         "+5544332211", "321 Pine St, CHI");
        
        customerDatabase.put(customer1.getId(), customer1);
        customerDatabase.put(customer2.getId(), customer2);
        customerDatabase.put(customer3.getId(), customer3);
        customerDatabase.put(customer4.getId(), customer4);
        
        System.out.println("Repository initialized with " + 
                          customerDatabase.size() + " customers");
    }
    
    @Override
    public Customer findCustomerById(String id) {
        Customer customer = customerDatabase.get(id);
        if (customer == null) {
            System.out.println("Customer with ID " + id + " not found in database");
        } else {
            System.out.println("Found customer: " + customer.getName() + 
                             " (ID: " + id + ")");
        }
        return customer;
    }
    
    @Override
    public List<Customer> findAllCustomers() {
        return new ArrayList<>(customerDatabase.values());
    }
    
    @Override
    public void saveCustomer(Customer customer) {
        if (customer.getId() == null || customer.getId().isEmpty()) {
            // Generate a new ID
            String newId = "C" + String.format("%03d", ++idCounter);
            customer.setId(newId);
        }
        customerDatabase.put(customer.getId(), customer);
        System.out.println("Customer saved: " + customer.getName() + 
                          " (ID: " + customer.getId() + ")");
    }
    
    @Override
    public void deleteCustomer(String id) {
        if (customerDatabase.containsKey(id)) {
            Customer removed = customerDatabase.remove(id);
            System.out.println("Customer deleted: " + removed.getName() + 
                             " (ID: " + id + ")");
        } else {
            System.out.println("Customer with ID " + id + " does not exist");
        }
    }
    
    @Override
    public boolean customerExists(String id) {
        return customerDatabase.containsKey(id);
    }
}
