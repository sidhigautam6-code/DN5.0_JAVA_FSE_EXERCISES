package main.java.com.cognizant.eurekadiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaDiscoveryServerApplication.class, args);
        System.out.println("========================================");
        System.out.println("Eureka Discovery Server Started!");
        System.out.println("Dashboard: http://localhost:8761");
        System.out.println("========================================");
    }
}