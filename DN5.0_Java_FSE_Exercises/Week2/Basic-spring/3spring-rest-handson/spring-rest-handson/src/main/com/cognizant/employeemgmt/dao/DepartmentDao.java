package com.cognizant.employeemgmt.dao;

import com.cognizant.employeemgmt.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDao {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentDao.class);

    // Static variable to hold department list
    private static List<Department> DEPARTMENT_LIST = new ArrayList<>();

    // Inject the department list from XML configuration
    @Resource(name = "departmentList")
    private List<Department> departmentListFromXml;

    /**
     * Constructor
     */
    public DepartmentDao() {
        logger.info("DepartmentDao initialized");
    }

    /**
     * Post construct method to load data from XML configuration
     */
    @PostConstruct
    public void init() {
        if (departmentListFromXml != null && !departmentListFromXml.isEmpty()) {
            DEPARTMENT_LIST = new ArrayList<>(departmentListFromXml);
            logger.info("Loaded {} departments from XML configuration", DEPARTMENT_LIST.size());
            logger.debug("Department list: {}", DEPARTMENT_LIST);
        } else {
            logger.warn("No departments found in XML configuration");
        }
    }

    /**
     * Get all departments
     * @return List of all departments
     */
    public List<Department> getAllDepartments() {
        logger.debug("Getting all departments - Total: {}", DEPARTMENT_LIST.size());
        return new ArrayList<>(DEPARTMENT_LIST); // Return a copy to prevent modification
    }

    /**
     * Get department by ID
     * @param id Department ID
     * @return Department object or null if not found
     */
    public Department getDepartmentById(Long id) {
        logger.debug("Getting department by ID: {}", id);
        return DEPARTMENT_LIST.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Get department by name
     * @param name Department name
     * @return Department object or null if not found
     */
    public Department getDepartmentByName(String name) {
        logger.debug("Getting department by name: {}", name);
        return DEPARTMENT_LIST.stream()
                .filter(department -> department.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Add a new department
     * @param department Department to add
     * @return Added department
     */
    public Department addDepartment(Department department) {
        // Generate new ID
        Long maxId = DEPARTMENT_LIST.stream()
                .map(Department::getId)
                .max(Long::compareTo)
                .orElse(0L);
        department.setId(maxId + 1);
        
        DEPARTMENT_LIST.add(department);
        logger.info("Added new department: {}", department.getName());
        return department;
    }

    /**
     * Get the total number of departments
     * @return Total count
     */
    public long getDepartmentCount() {
        return DEPARTMENT_LIST.size();
    }
}