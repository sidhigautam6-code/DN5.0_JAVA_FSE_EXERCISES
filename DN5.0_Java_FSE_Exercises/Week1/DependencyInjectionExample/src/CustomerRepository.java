package Week1.DependencyInjectionExample.src;
// src/CustomerRepository.java
import java.util.List;

public interface CustomerRepository {
    Customer findCustomerById(String id);
    List<Customer> findAllCustomers();
    void saveCustomer(Customer customer);
    void deleteCustomer(String id);
    boolean customerExists(String id);
}
