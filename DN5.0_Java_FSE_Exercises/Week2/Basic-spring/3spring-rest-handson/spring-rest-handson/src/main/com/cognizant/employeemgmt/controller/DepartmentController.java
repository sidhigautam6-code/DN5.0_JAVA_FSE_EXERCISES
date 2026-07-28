package com.cognizant.employeemgmt.controller;

import com.cognizant.employeemgmt.model.Department;
import com.cognizant.employeemgmt.service.DepartmentService;
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
public class DepartmentController {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    /**
     * Get all departments
     * GET /api/departments
     * @return List of all departments
     */
    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        logger.info("REST request to get all departments");
        try {
            List<Department> departments = departmentService.getAllDepartments();
            logger.info("Returning {} departments", departments.size());
            logger.debug("Departments: {}", departments);
            return ResponseEntity.ok(departments);
        } catch (Exception e) {
            logger.error("Error getting departments: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get department by ID
     * GET /api/departments/{id}
     * @param id Department ID
     * @return Department object
     */
    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        logger.info("REST request to get department by ID: {}", id);
        try {
            Department department = departmentService.getDepartmentById(id);
            if (department != null) {
                logger.info("Found department: {}", department.getName());
                return ResponseEntity.ok(department);
            } else {
                logger.warn("Department not found with ID: {}", id);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Error getting department by ID: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get department by name
     * GET /api/departments/name/{name}
     * @param name Department name
     * @return Department object
     */
    @GetMapping("/departments/name/{name}")
    public ResponseEntity<Department> getDepartmentByName(@PathVariable String name) {
        logger.info("REST request to get department by name: {}", name);
        try {
            Department department = departmentService.getDepartmentByName(name);
            if (department != null) {
                logger.info("Found department: {}", department.getName());
                return ResponseEntity.ok(department);
            } else {
                logger.warn("Department not found with name: {}", name);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Error getting department by name: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Add a new department
     * POST /api/departments
     * @param department Department to add
     * @return Added department
     */
    @PostMapping("/departments")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        logger.info("REST request to add department: {}", department.getName());
        try {
            Department newDepartment = departmentService.addDepartment(department);
            return ResponseEntity.status(HttpStatus.CREATED).body(newDepartment);
        } catch (Exception e) {
            logger.error("Error adding department: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get department count
     * GET /api/departments/count
     * @return Total number of departments
     */
    @GetMapping("/departments/count")
    public ResponseEntity<Long> getDepartmentCount() {
        logger.info("REST request to get department count");
        try {
            long count = departmentService.getDepartmentCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            logger.error("Error getting department count: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}