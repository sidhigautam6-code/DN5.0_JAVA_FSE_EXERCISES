package Week1.EmployeeManagementSystem;
// src/TestEmployeeManagement.java
public class TestEmployeeManagement {
    public static void main(String[] args) {
        System.out.println("=== EMPLOYEE MANAGEMENT SYSTEM ===\n");
        
        // Create employee manager
        EmployeeArrayManager manager = new EmployeeArrayManager(5);
        
        // Add employees
        System.out.println("\n--- Adding Employees ---");
        addSampleEmployees(manager);
        
        // Display all employees
        manager.displayAllEmployees();
        
        // Search operations
        System.out.println("\n--- Search Operations ---");
        Employee found = manager.findEmployee("E001");
        if (found != null) {
            System.out.println("Found: " + found);
        }
        
        // Find by name
        Employee[] byName = manager.findEmployeesByName("Jane Smith");
        System.out.println("\nEmployees named 'Jane Smith':");
        for (Employee e : byName) {
            System.out.println("  " + e);
        }
        
        // Update employee
        System.out.println("\n--- Updating Employee ---");
        manager.updateEmployee("E001", null, "Senior Developer", 85000.00, 
                              "Technology", "john.updated@email.com");
        
        // Department filter
        System.out.println("\n--- Employees by Department ---");
        Employee[] hrEmployees = manager.getEmployeesByDepartment("Human Resources");
        System.out.println("HR Department Employees:");
        for (Employee e : hrEmployees) {
            System.out.println("  " + e);
        }
        
        // Delete employee
        System.out.println("\n--- Deleting Employee ---");
        manager.deleteEmployee("E005");
        
        // Final display
        manager.displayAllEmployees();
        
        // Statistics
        System.out.println("\n--- Statistics ---");
        System.out.println("Total Employees: " + manager.getSize());
        System.out.println("Total Salary Expense: $" + 
                          String.format("%.2f", manager.getTotalSalaryExpense()));
        System.out.println("Average Salary: $" + 
                          String.format("%.2f", manager.getTotalSalaryExpense() / manager.getSize()));
    }
    
    private static void addSampleEmployees(EmployeeArrayManager manager) {
        manager.addEmployee(new Employee("E001", "John Doe", "Software Engineer", 
                                       75000.00, "Technology", "john@company.com"));
        manager.addEmployee(new Employee("E002", "Jane Smith", "HR Manager", 
                                       65000.00, "Human Resources", "jane@company.com"));
        manager.addEmployee(new Employee("E003", "Bob Johnson", "Marketing Director", 
                                       80000.00, "Marketing", "bob@company.com"));
        manager.addEmployee(new Employee("E004", "Alice Brown", "Financial Analyst", 
                                       70000.00, "Finance", "alice@company.com"));
        manager.addEmployee(new Employee("E005", "Charlie Wilson", "Software Engineer", 
                                       72000.00, "Technology", "charlie@company.com"));
    }
}
