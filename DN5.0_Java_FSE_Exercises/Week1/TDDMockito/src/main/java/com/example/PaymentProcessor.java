package com.example;

/**
 * A payment processor that depends on external services.
 */
public class PaymentProcessor {
    
    private ExternalApi externalApi;
    
    public PaymentProcessor(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }
    
    /**
     * Processes a payment.
     * @param amount the payment amount
     * @param userId the user ID
     * @return true if payment was processed successfully
     */
    public boolean processPayment(double amount, int userId) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        
        if (userId < 1) {
            throw new IllegalArgumentException("Invalid user ID");
        }
        
        // First check if the API is healthy
        if (!externalApi.isHealthy()) {
            return false;
        }
        
        // Get user data to process payment
        String userData = externalApi.getUserData(userId);
        
        if (userData == null || userData.equals("User not found")) {
            return false;
        }
        
        // Process payment
        // In real implementation, this would call a payment gateway
        return true;
    }
    
    /**
     * Gets the user's payment history.
     * @param userId the user ID
     * @return array of payment amounts
     */
    public double[] getUserPaymentHistory(int userId) {
        if (userId < 1) {
            return new double[0];
        }
        
        // This would normally fetch from the API
        return new double[]{100.50, 200.75, 50.25};
    }
}