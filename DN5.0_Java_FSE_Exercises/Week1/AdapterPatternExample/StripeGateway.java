package Week1.AdapterPatternExample;
// src/StripeGateway.java
public class StripeGateway {
    public void chargeCard(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe");
        // Stripe specific implementation
    }
}
