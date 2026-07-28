package com.cognizant.employeemgmt.service;

import com.cognizant.employeemgmt.dao.DepartmentDao;
import com.cognizant.employeemgmt.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * Get all departments
     * @return List of all departments
     */
    @Transactional(readOnly = true)
    public List<Department> getAllDepartments() {
        logger.info("Fetching all departments from service");
        return departmentDao.getAllDepartments();
    }

    /**
     * Get department by ID
     * @param id Department ID
     * @return Department object
     */
    @Transactional(readOnly = true)
    public Department getDepartmentById(Long id) {
        logger.info("Fetching department by ID: {}", id);
        return departmentDao.getDepartmentById(id);
    }

    /**
     * Get department by name
     * @param name Department name
     * @return Department object
     */
    @Transactional(readOnly = true)
    public Department getDepartmentByName(String name) {
        logger.info("Fetching department by name: {}", name);
        return departmentDao.getDepartmentByName(name);
    }

    /**
     * Add a new department
     * @param department Department to add
     * @return Added department
     */
    @Transactional
    public Department addDepartment(Department department) {
        logger.info("Adding new department: {}", department.getName());
        return departmentDao.addDepartment(department);
    }

    /**
     * Get total department count
     * @return Total count
     */
    @Transactional(readOnly = true)
    public long getDepartmentCount() {
        logger.info("Getting department count");
        return departmentDao.getDepartmentCount();
    }
}