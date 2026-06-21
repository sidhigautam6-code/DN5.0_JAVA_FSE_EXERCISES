package Week1.EmployeeManagementSystem;
// src/Employee.java
public class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;
    private String department;
    private String email;
    
    public Employee(String employeeId, String name, String position, 
                    double salary, String department, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.department = department;
        this.email = email;
    }
    
    // Getters and Setters
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public String getEmail() { return email; }
    
    public void setName(String name) { this.name = name; }
    public void setPosition(String position) { this.position = position; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setDepartment(String department) { this.department = department; }
    public void setEmail(String email) { this.email = email; }
    
    @Override
    public String toString() {
        return String.format("Employee[ID: %s, Name: %s, Position: %s, " +
                           "Salary: $%.2f, Dept: %s, Email: %s]",
                           employeeId, name, position, salary, department, email);
    }
}
