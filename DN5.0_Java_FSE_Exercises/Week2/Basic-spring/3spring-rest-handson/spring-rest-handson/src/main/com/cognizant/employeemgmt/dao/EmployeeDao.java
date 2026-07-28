package com.cognizant.employeemgmt.dao;

import com.cognizant.employeemgmt.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);

    // Static variable to hold employee list
    private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    // Inject the employee list from XML configuration
    @Resource(name = "employeeList")
    private List<Employee> employeeListFromXml;

    /**
     * Constructor that reads employee list from xml config and sets the EMPLOYEE_LIST
     */
    public EmployeeDao() {
        logger.info("EmployeeDao initialized");
    }

    /**
     * Post construct method to load data from XML configuration
     */
    @PostConstruct
    public void init() {
        if (employeeListFromXml != null && !employeeListFromXml.isEmpty()) {
            EMPLOYEE_LIST = new ArrayList<>(employeeListFromXml);
            logger.info("Loaded {} employees from XML configuration", EMPLOYEE_LIST.size());
            logger.debug("Employee list: {}", EMPLOYEE_LIST);
        } else {
            logger.warn("No employees found in XML configuration");
        }
    }

    /**
     * Get all employees
     * @return List of all employees
     */
    public List<Employee> getAllEmployees() {
        logger.debug("Getting all employees - Total: {}", EMPLOYEE_LIST.size());
        return new ArrayList<>(EMPLOYEE_LIST); // Return a copy to prevent modification
    }

    /**
     * Get employee by ID
     * @param id Employee ID
     * @return Employee object or null if not found
     */
    public Employee getEmployeeById(Long id) {
        logger.debug("Getting employee by ID: {}", id);
        return EMPLOYEE_LIST.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Add a new employee
     * @param employee Employee to add
     * @return Added employee
     */
    public Employee addEmployee(Employee employee) {
        // Generate new ID
        Long maxId = EMPLOYEE_LIST.stream()
                .map(Employee::getId)
                .max(Long::compareTo)
                .orElse(0L);
        employee.setId(maxId + 1);
        
        EMPLOYEE_LIST.add(employee);
        logger.info("Added new employee: {}", employee.getFullName());
        return employee;
    }

    /**
     * Update an existing employee
     * @param employee Employee with updated data
     * @return Updated employee or null if not found
     */
    public Employee updateEmployee(Employee employee) {
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            Employee existing = EMPLOYEE_LIST.get(i);
            if (existing.getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                logger.info("Updated employee: {}", employee.getFullName());
                return employee;
            }
        }
        logger.warn("Employee not found for update: ID {}", employee.getId());
        return null;
    }

    /**
     * Delete an employee
     * @param id Employee ID to delete
     * @return true if deleted, false if not found
     */
    public boolean deleteEmployee(Long id) {
        boolean removed = EMPLOYEE_LIST.removeIf(employee -> employee.getId().equals(id));
        if (removed) {
            logger.info("Deleted employee with ID: {}", id);
        } else {
            logger.warn("Employee not found for deletion: ID {}", id);
        }
        return removed;
    }

    /**
     * Get employees by department
     * @param departmentId Department ID
     * @return List of employees in the department
     */
    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        logger.debug("Getting employees for department ID: {}", departmentId);
        return EMPLOYEE_LIST.stream()
                .filter(employee -> employee.getDepartment() != null 
                        && employee.getDepartment().getId().equals(departmentId))
                .collect(java.util.stream.Collectors.toList());
    }

    /**
     * Get active employees
     * @return List of active employees
     */
    public List<Employee> getActiveEmployees() {
        logger.debug("Getting active employees");
        return EMPLOYEE_LIST.stream()
                .filter(Employee::getActive)
                .collect(java.util.stream.Collectors.toList());
    }

    /**
     * Get the total number of employees
     * @return Total count
     */
    public long getEmployeeCount() {
        return EMPLOYEE_LIST.size();
    }
}