package Week1.DependencyInjectionExample.src;
// src/CustomerService.java
import java.util.List;

public class CustomerService {
    // Dependency injection through constructor
    private final CustomerRepository customerRepository;
    private String serviceName;
    
    // Constructor Injection - Primary method of DI
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.serviceName = "CustomerService v1.0";
        System.out.println("CustomerService initialized with repository");
    }
    
    // Setter Injection - Alternative method
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    // Business methods
    public Customer findCustomer(String id) {
        System.out.println("\n[" + serviceName + "] Searching for customer: " + id);
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            System.out.println("[" + serviceName + "] Customer not found");
            return null;
        }
        System.out.println("[" + serviceName + "] Customer found successfully");
        return customer;
    }
    
    public void displayCustomerDetails(String id) {
        Customer customer = findCustomer(id);
        if (customer != null) {
            System.out.println("--- Customer Details ---");
            System.out.println(customer);
            System.out.println("------------------------");
        }
    }
    
    public void displayAllCustomers() {
        List<Customer> customers = customerRepository.findAllCustomers();
        System.out.println("\n[" + serviceName + "] Displaying all customers:");
        System.out.println("Total customers: " + customers.size());
        System.out.println("=====================");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        System.out.println("=====================");
    }
    
    public void addNewCustomer(String name, String email, String phone, String address) {
        Customer newCustomer = new Customer(null, name, email, phone, address);
        System.out.println("\n[" + serviceName + "] Adding new customer: " + name);
        customerRepository.saveCustomer(newCustomer);
    }
    
    public void deleteCustomer(String id) {
        System.out.println("\n[" + serviceName + "] Deleting customer: " + id);
        if (customerRepository.customerExists(id)) {
            customerRepository.deleteCustomer(id);
            System.out.println("[" + serviceName + "] Customer deleted successfully");
        } else {
            System.out.println("[" + serviceName + "] Customer does not exist");
        }
    }
}
