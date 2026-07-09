package com.cognizant.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoanApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class, args);
        System.out.println("========================================");
        System.out.println("Loan Microservice Started Successfully!");
        System.out.println("Access at: http://localhost:8081");
        System.out.println("========================================");
    }
}