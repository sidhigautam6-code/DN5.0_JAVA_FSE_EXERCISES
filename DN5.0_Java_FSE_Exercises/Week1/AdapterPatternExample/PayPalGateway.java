package Week1.AdapterPatternExample;
// src/PayPalGateway.java
public class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal");
        // PayPal specific implementation
    }
}
