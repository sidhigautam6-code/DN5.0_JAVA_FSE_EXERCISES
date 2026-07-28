package com.cognizant.employeemgmt.controller;

import com.cognizant.employeemgmt.model.Employee;
import com.cognizant.employeemgmt.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Enable CORS for Angular frontend
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    /**
     * Get all employees
     * GET /api/employees
     * @return List of all employees
     */
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        logger.info("REST request to get all employees");
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            logger.info("Returning {} employees", employees.size());
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            logger.error("Error getting employees: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get employee by ID
     * GET /api/employees/{id}
     * @param id Employee ID
     * @return Employee object
     */
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        logger.info("REST request to get employee by ID: {}", id);
        try {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee != null) {
                logger.info("Found employee: {}", employee.getFullName());
                return ResponseEntity.ok(employee);
            } else {
                logger.warn("Employee not found with ID: {}", id);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Error getting employee by ID: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Add a new employee
     * POST /api/employees
     * @param employee Employee to add
     * @return Added employee
     */
    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        logger.info("REST request to add employee: {}", employee.getFullName());
        try {
            Employee newEmployee = employeeService.addEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
        } catch (Exception e) {
            logger.error("Error adding employee: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Update an existing employee
     * PUT /api/employees/{id}
     * @param id Employee ID
     * @param employee Updated employee data
     * @return Updated employee
     */
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        logger.info("REST request to update employee with ID: {}", id);
        try {
            // Ensure the ID in the path matches the ID in the request body
            if (!id.equals(employee.getId())) {
                logger.warn("ID mismatch: Path ID={}, Body ID={}", id, employee.getId());
                return ResponseEntity.badRequest().build();
            }
            
            Employee updatedEmployee = employeeService.updateEmployee(employee);
            if (updatedEmployee != null) {
                logger.info("Updated employee: {}", updatedEmployee.getFullName());
                return ResponseEntity.ok(updatedEmployee);
            } else {
                logger.warn("Employee not found with ID: {}", id);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Error updating employee: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Delete an employee
     * DELETE /api/employees/{id}
     * @param id Employee ID to delete
     * @return Response with no content
     */
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        logger.info("REST request to delete employee with ID: {}", id);
        try {
            boolean deleted = employeeService.deleteEmployee(id);
            if (deleted) {
                logger.info("Deleted employee with ID: {}", id);
                return ResponseEntity.noContent().build();
            } else {
                logger.warn("Employee not found with ID: {}", id);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Error deleting employee: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get employees by department
     * GET /api/employees/department/{departmentId}
     * @param departmentId Department ID
     * @return List of employees in the department
     */
    @GetMapping("/employees/department/{departmentId}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable Long departmentId) {
        logger.info("REST request to get employees by department ID: {}", departmentId);
        try {
            List<Employee> employees = employeeService.getEmployeesByDepartment(departmentId);
            logger.info("Found {} employees in department", employees.size());
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            logger.error("Error getting employees by department: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get active employees
     * GET /api/employees/active
     * @return List of active employees
     */
    @GetMapping("/employees/active")
    public ResponseEntity<List<Employee>> getActiveEmployees() {
        logger.info("REST request to get active employees");
        try {
            List<Employee> employees = employeeService.getActiveEmployees();
            logger.info("Found {} active employees", employees.size());
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            logger.error("Error getting active employees: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get employee count
     * GET /api/employees/count
     * @return Total number of employees
     */
    @GetMapping("/employees/count")
    public ResponseEntity<Long> getEmployeeCount() {
        logger.info("REST request to get employee count");
        try {
            long count = employeeService.getEmployeeCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            logger.error("Error getting employee count: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}