package Week1.DependencyInjectionExample.src;
// src/Customer.java
public class Customer {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    
    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public Customer(String id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    
    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    
    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer[ID: ").append(id);
        sb.append(", Name: ").append(name);
        sb.append(", Email: ").append(email);
        if (phone != null) sb.append(", Phone: ").append(phone);
        if (address != null) sb.append(", Address: ").append(address);
        sb.append("]");
        return sb.toString();
    }
}
