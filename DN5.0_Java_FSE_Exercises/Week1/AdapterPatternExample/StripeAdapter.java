package Week1.AdapterPatternExample;
// src/StripeAdapter.java
public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;
    
    public StripeAdapter() {
        this.stripeGateway = new StripeGateway();
    }
    
    @Override
    public void processPayment(double amount) {
        stripeGateway.chargeCard(amount);
    }
}
