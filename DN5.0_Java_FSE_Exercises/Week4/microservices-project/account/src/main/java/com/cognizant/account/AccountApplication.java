package com.cognizant.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
        System.out.println("========================================");
        System.out.println("Account Microservice Started Successfully!");
        System.out.println("Access at: http://localhost:8080");
        System.out.println("========================================");
    }
}