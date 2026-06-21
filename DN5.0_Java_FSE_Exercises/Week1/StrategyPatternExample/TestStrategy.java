package Week1.StrategyPatternExample;
// src/TestStrategy.java
public class TestStrategy {
    public static void main(String[] args) {
        // Create payment context
        PaymentContext context = new PaymentContext(null);
        
        // Create payment strategies
        PaymentStrategy creditCard = new CreditCardPayment(
            "1234567890123456", "John Doe", "12/25", "123");
        PaymentStrategy payPal = new PayPalPayment("john@email.com", "password");
        
        // Use credit card payment
        context.setPaymentStrategy(creditCard);
        System.out.println("Credit Card Payment:");
        context.pay(250.50);
        
        // Switch to PayPal payment
        context.setPaymentStrategy(payPal);
        System.out.println("\nPayPal Payment:");
        context.pay(100.00);
        
        // Demo: direct usage without context
        System.out.println("\nDirect Strategy Usage:");
        creditCard.pay(75.25);
        payPal.pay(200.00);
    }
}
