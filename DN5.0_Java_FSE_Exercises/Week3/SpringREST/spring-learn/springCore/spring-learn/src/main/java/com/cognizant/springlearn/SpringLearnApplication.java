package main.java.com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    // Logger instance
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START - SpringLearnApplication.main()");
        
        // Run the Spring Boot application
        SpringApplication.run(SpringLearnApplication.class, args);
        
        // Create an instance to call non-static methods
        SpringLearnApplication app = new SpringLearnApplication();
        
        // Call displayCountry() method
        app.displayCountry();
        
        LOGGER.info("END - SpringLearnApplication.main()");
    }

    /**
     * displayCountry() method
     * Loads Country bean from Spring XML configuration
     * and displays the country details
     */
    public void displayCountry() {
        LOGGER.info("START - displayCountry()");
        
        try {
            // 1. Load Spring configuration from country.xml
            // ClassPathXmlApplicationContext looks for XML file in classpath
            ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
            LOGGER.debug("ApplicationContext created successfully.");
            
            // 2. Get the country bean from Spring container
            // getBean() retrieves the bean with id "country" and casts to Country class
            Country country = context.getBean("country", Country.class);
            LOGGER.debug("Country bean retrieved successfully.");
            
            // 3. Display the country details using toString()
            LOGGER.debug("Country : {}", country.toString());
            
            // 4. Display individual properties (alternative way)
            LOGGER.debug("Country Code: {}", country.getCode());
            LOGGER.debug("Country Name: {}", country.getName());
            
            // 5. Close the application context to release resources
            ((ClassPathXmlApplicationContext) context).close();
            LOGGER.debug("ApplicationContext closed.");
            
        } catch (Exception e) {
            LOGGER.error("Error in displayCountry(): {}", e.getMessage());
            e.printStackTrace();
        }
        
        LOGGER.info("END - displayCountry()");
    }
}