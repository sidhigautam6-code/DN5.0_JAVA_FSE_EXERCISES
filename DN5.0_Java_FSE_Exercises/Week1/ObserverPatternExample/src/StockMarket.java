package Week1.ObserverPatternExample.src;
// src/StockMarket.java
import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;
    
    public StockMarket(String stockName, double initialPrice) {
        this.observers = new ArrayList<>();
        this.stockName = stockName;
        this.stockPrice = initialPrice;
        System.out.println("Stock Market created for: " + stockName + 
                          " (Initial Price: $" + initialPrice + ")");
    }
    
    @Override
    public void registerObserver(Observer observer) {
        if (observer == null) {
            System.out.println("Cannot register null observer");
            return;
        }
        
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println(observer.getClass().getSimpleName() + 
                              " registered for " + stockName);
        } else {
            System.out.println(observer.getClass().getSimpleName() + 
                              " already registered");
        }
    }
    
    @Override
    public void deregisterObserver(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println(observer.getClass().getSimpleName() + 
                              " deregistered from " + stockName);
        } else {
            System.out.println(observer.getClass().getSimpleName() + 
                              " was not registered");
        }
    }
    
    @Override
    public void notifyObservers() {
        if (observers.isEmpty()) {
            System.out.println("No observers to notify");
            return;
        }
        
        System.out.println("Notifying " + observers.size() + " observers...");
        for (Observer observer : observers) {
            // Cast to Stock to match Observer.update(Stock) signature if implemented that way
            observer.update((Stock) this);
        }
    }
    
    public void setStockPrice(double newPrice) {
        if (this.stockPrice != newPrice) {
            System.out.println("\n=== Stock Price Update ===");
            System.out.println(stockName + " price changed from $" + 
                              String.format("%.2f", stockPrice) + 
                              " to $" + String.format("%.2f", newPrice));
            this.stockPrice = newPrice;
            notifyObservers();
        } else {
            System.out.println("Price unchanged: $" + String.format("%.2f", newPrice));
        }
    }
    
    public double getStockPrice() {
        return stockPrice;
    }
    
    public String getStockName() {
        return stockName;
    }
}
