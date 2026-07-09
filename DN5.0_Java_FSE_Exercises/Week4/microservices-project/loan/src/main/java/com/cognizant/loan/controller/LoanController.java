package main.java.com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable String number) {
        Map<String, Object> response = new HashMap<>();
        response.put("loanNumber", number);
        response.put("type", "Home Loan");
        response.put("loanAmount", 5000000.00);
        response.put("emi", 42500.00);
        response.put("tenure", 20);
        response.put("interestRate", 7.5);
        response.put("status", "Active");
        response.put("accountNumber", "ACC123456");
        response.put("timestamp", System.currentTimeMillis());
        return response;
    }

    @GetMapping("/health")
    public Map<String, String> healthCheck() {
        Map<String, String> health = new HashMap<>();
        health.put("status", "UP");
        health.put("service", "Loan Service");
        health.put("port", "8081");
        return health;
    }

    @GetMapping("/info")
    public Map<String, String> getInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("serviceName", "Loan Microservice");
        info.put("version", "1.0.0");
        info.put("description", "Manages bank loan operations");
        return info;
    }
}