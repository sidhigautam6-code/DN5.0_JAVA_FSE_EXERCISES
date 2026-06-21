package Week1.AdapterPatternExample;
// src/TestAdapter.java
public class TestAdapter {
    public static void main(String[] args) {
        PaymentProcessor stripeProcessor = new StripeAdapter();
        PaymentProcessor payPalProcessor = new PayPalAdapter();
        
        // Process payments using different processors
        stripeProcessor.processPayment(100.50);
        payPalProcessor.processPayment(75.25);
        
        // Another way: using a single method that accepts any PaymentProcessor
        processOrder(stripeProcessor, 200.00);
        processOrder(payPalProcessor, 150.75);
    }
    
    public static void processOrder(PaymentProcessor processor, double amount) {
        processor.processPayment(amount);
    }
}
