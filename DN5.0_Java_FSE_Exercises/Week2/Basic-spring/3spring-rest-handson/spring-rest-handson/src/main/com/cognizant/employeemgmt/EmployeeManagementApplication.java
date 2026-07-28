package com.cognizant.employeemgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:employee.xml")
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
        System.out.println("\n========================================");
        System.out.println("🚀 Employee Management REST API Started!");
        System.out.println("========================================");
        System.out.println("📌 Base URL: http://localhost:8080/api");
        System.out.println("📌 Employees: http://localhost:8080/api/employees");
        System.out.println("📌 Departments: http://localhost:8080/api/departments");
        System.out.println("========================================\n");
    }
}