package Week1.EmployeeManagementSystem;
// src/EmployeeArrayManager.java
public class EmployeeArrayManager {
    private Employee[] employees;
    private int size;
    private static final int INITIAL_CAPACITY = 10;
    
    public EmployeeArrayManager() {
        this.employees = new Employee[INITIAL_CAPACITY];
        this.size = 0;
        System.out.println("Employee Array Manager initialized with capacity: " + 
                          INITIAL_CAPACITY);
    }
    
    public EmployeeArrayManager(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.employees = new Employee[initialCapacity];
        this.size = 0;
        System.out.println("Employee Array Manager initialized with capacity: " + 
                          initialCapacity);
    }
    
    // Add Employee - O(1) average, O(n) when resizing
    public void addEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("Cannot add null employee");
            return;
        }
        
        // Check if employee ID already exists
        if (findEmployeeIndex(employee.getEmployeeId()) != -1) {
            System.out.println("Employee already exists: " + employee.getEmployeeId());
            return;
        }
        
        // Ensure capacity
        if (size == employees.length) {
            resizeArray();
        }
        
        employees[size++] = employee;
        System.out.println("Employee added: " + employee.getName());
    }
    
    // Search Employee by ID - O(n)
    public Employee findEmployee(String employeeId) {
        int index = findEmployeeIndex(employeeId);
        if (index == -1) {
            System.out.println("Employee not found: " + employeeId);
            return null;
        }
        return employees[index];
    }
    
    // Search Employee by Name - O(n)
    public Employee[] findEmployeesByName(String name) {
        if (name == null || name.isEmpty()) {
            return new Employee[0];
        }
        
        // Count matches
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getName().equalsIgnoreCase(name)) {
                count++;
            }
        }
        
        // Collect matches
        Employee[] matches = new Employee[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getName().equalsIgnoreCase(name)) {
                matches[index++] = employees[i];
            }
        }
        return matches;
    }
    
    // Delete Employee - O(n)
    public void deleteEmployee(String employeeId) {
        int index = findEmployeeIndex(employeeId);
        if (index == -1) {
            System.out.println("Employee not found: " + employeeId);
            return;
        }
        
        // Shift elements left
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--size] = null;
        System.out.println("Employee deleted: " + employeeId);
    }
    
    // Traverse all employees - O(n)
    public void displayAllEmployees() {
        if (size == 0) {
            System.out.println("No employees in the system");
            return;
        }
        
        System.out.println("\n=== EMPLOYEE LIST ===");
        System.out.println("Total employees: " + size);
        System.out.println("Capacity: " + employees.length);
        System.out.println("--------------------");
        
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + employees[i]);
        }
        System.out.println("====================\n");
    }
    
    // Get employees by department - O(n)
    public Employee[] getEmployeesByDepartment(String department) {
        if (department == null) {
            return new Employee[0];
        }
        
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment().equalsIgnoreCase(department)) {
                count++;
            }
        }
        
        Employee[] deptEmployees = new Employee[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment().equalsIgnoreCase(department)) {
                deptEmployees[index++] = employees[i];
            }
        }
        return deptEmployees;
    }
    
    // Get total salary expense - O(n)
    public double getTotalSalaryExpense() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += employees[i].getSalary();
        }
        return total;
    }
    
    // Update employee details - O(n)
    public void updateEmployee(String employeeId, String name, String position, 
                               double salary, String department, String email) {
        int index = findEmployeeIndex(employeeId);
        if (index == -1) {
            System.out.println("Employee not found: " + employeeId);
            return;
        }
        
        Employee emp = employees[index];
        if (name != null) emp.setName(name);
        if (position != null) emp.setPosition(position);
        if (salary >= 0) emp.setSalary(salary);
        if (department != null) emp.setDepartment(department);
        if (email != null) emp.setEmail(email);
        
        System.out.println("Employee updated: " + employeeId);
    }
    
    private int findEmployeeIndex(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return i;
            }
        }
        return -1;
    }
    
    private void resizeArray() {
        int newCapacity = employees.length * 2;
        Employee[] newArray = new Employee[newCapacity];
        System.arraycopy(employees, 0, newArray, 0, size);
        employees = newArray;
        System.out.println("Array resized to capacity: " + newCapacity);
    }
    
    public int getSize() { return size; }
    public int getCapacity() { return employees.length; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == employees.length; }
}
