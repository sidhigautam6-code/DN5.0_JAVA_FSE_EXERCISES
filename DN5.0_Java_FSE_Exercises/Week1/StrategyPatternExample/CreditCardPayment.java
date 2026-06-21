package Week1.StrategyPatternExample;
// src/CreditCardPayment.java
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;
    
    public CreditCardPayment(String cardNumber, String cardHolderName, 
                            String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card");
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Number: ****" + 
                          cardNumber.substring(cardNumber.length() - 4));
    }
}
