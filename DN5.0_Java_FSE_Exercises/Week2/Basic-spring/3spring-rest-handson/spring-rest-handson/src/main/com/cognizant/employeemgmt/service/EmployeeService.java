package com.cognizant.employeemgmt.service;

import com.cognizant.employeemgmt.dao.EmployeeDao;
import com.cognizant.employeemgmt.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * Get all employees
     * @return List of all employees
     */
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees from service");
        return employeeDao.getAllEmployees();
    }

    /**
     * Get employee by ID
     * @param id Employee ID
     * @return Employee object
     */
    @Transactional(readOnly = true)
    public Employee getEmployeeById(Long id) {
        logger.info("Fetching employee by ID: {}", id);
        return employeeDao.getEmployeeById(id);
    }

    /**
     * Add a new employee
     * @param employee Employee to add
     * @return Added employee
     */
    @Transactional
    public Employee addEmployee(Employee employee) {
        logger.info("Adding new employee: {}", employee.getFullName());
        return employeeDao.addEmployee(employee);
    }

    /**
     * Update an existing employee
     * @param employee Employee with updated data
     * @return Updated employee
     */
    @Transactional
    public Employee updateEmployee(Employee employee) {
        logger.info("Updating employee: {}", employee.getFullName());
        return employeeDao.updateEmployee(employee);
    }

    /**
     * Delete an employee
     * @param id Employee ID to delete
     * @return true if deleted
     */
    @Transactional
    public boolean deleteEmployee(Long id) {
        logger.info("Deleting employee with ID: {}", id);
        return employeeDao.deleteEmployee(id);
    }

    /**
     * Get employees by department
     * @param departmentId Department ID
     * @return List of employees in the department
     */
    @Transactional(readOnly = true)
    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        logger.info("Fetching employees for department ID: {}", departmentId);
        return employeeDao.getEmployeesByDepartment(departmentId);
    }

    /**
     * Get active employees
     * @return List of active employees
     */
    @Transactional(readOnly = true)
    public List<Employee> getActiveEmployees() {
        logger.info("Fetching active employees");
        return employeeDao.getActiveEmployees();
    }

    /**
     * Get total employee count
     * @return Total count
     */
    @Transactional(readOnly = true)
    public long getEmployeeCount() {
        logger.info("Getting employee count");
        return employeeDao.getEmployeeCount();
    }
}