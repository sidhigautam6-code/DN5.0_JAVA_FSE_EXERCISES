package com.example;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class AppTest {
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);
    
    @Test
    public void testLoggingExample() {
        LoggingExample.main(new String[]{});
        assertTrue(true);
    }
    
    @Test
    public void testParameterizedLogging() {
        ParameterizedLoggingExample.main(new String[]{});
        assertTrue(true);
    }
    
    @Test
    public void testAppenderExample() {
        AppenderExample.main(new String[]{});
        assertTrue(true);
    }
    
    @Test
    public void testLoggerInitialization() {
        assertNotNull(logger);
        logger.info("Test logger is working");
        assertTrue(true);
    }
}