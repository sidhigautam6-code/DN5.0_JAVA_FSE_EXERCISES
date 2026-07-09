package main.java.com.cognizant.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
        System.out.println("========================================");
        System.out.println("Account Microservice Started!");
        System.out.println("Access at: http://localhost:8080");
        System.out.println("Registered with Eureka!");
        System.out.println("========================================");
    }
}