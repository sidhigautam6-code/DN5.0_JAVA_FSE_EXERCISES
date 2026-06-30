package com.example;

/**
 * Simulates an email service.
 */
public class EmailService {
    
    /**
     * Sends a welcome email.
     * @param email the recipient email
     * @param username the username
     */
    public void sendWelcomeEmail(String email, String username) {
        System.out.println("Sending welcome email to: " + email);
        System.out.println("Welcome, " + username + "!");
    }
    
    /**
     * Sends a deletion notification.
     * @param username the username
     */
    public void sendDeletionNotification(String username) {
        System.out.println("Sending deletion notification for: " + username);
    }
    
    /**
     * Sends an email with subject and body.
     * @param to recipient email
     * @param subject email subject
     * @param body email body
     * @return true if email was sent
     */
    public boolean sendEmail(String to, String subject, String body) {
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        return true;
    }
}