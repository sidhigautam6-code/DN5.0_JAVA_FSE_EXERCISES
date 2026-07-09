package main.java.com.cognizant.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping("/{number}")
    public Map<String, Object> getAccountDetails(@PathVariable String number) {
        Map<String, Object> response = new HashMap<>();
        response.put("accountNumber", number);
        response.put("accountHolder", "John Doe");
        response.put("balance", 50000.00);
        response.put("accountType", "Savings");
        response.put("branch", "Main Branch");
        response.put("ifscCode", "CBIN0123456");
        response.put("status", "Active");
        response.put("timestamp", System.currentTimeMillis());
        return response;
    }

    @GetMapping("/health")
    public Map<String, String> healthCheck() {
        Map<String, String> health = new HashMap<>();
        health.put("status", "UP");
        health.put("service", "Account Service");
        health.put("port", "8080");
        return health;
    }

    @GetMapping("/eureka-status")
    public String eurekaStatus() {
        return "Account Service is registered with Eureka!";
    }
}