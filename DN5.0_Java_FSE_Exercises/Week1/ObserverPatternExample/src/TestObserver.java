package Week1.ObserverPatternExample.src;
// src/TestObserver.java
public class TestObserver {
    public static void main(String[] args) {
        System.out.println("=== OBSERVER PATTERN DEMONSTRATION ===\n");
        
        // Create stock market instances
        StockMarket appleStock = new StockMarket("AAPL", 175.50);
        StockMarket googleStock = new StockMarket("GOOGL", 2850.00);
        StockMarket teslaStock = new StockMarket("TSLA", 750.25);
        
        System.out.println("\n=== Creating Observers ===");
        // Create observers
        Observer mobileApp1 = new MobileApp();
        Observer mobileApp2 = new MobileApp("Mobile App Pro");
        Observer webApp1 = new WebApp();
        Observer webApp2 = new WebApp("Web App Enterprise");
        
        System.out.println("\n=== Registering Observers for Apple Stock ===");
        appleStock.registerObserver(mobileApp1);
        appleStock.registerObserver(webApp1);
        appleStock.registerObserver(mobileApp2);
        
        System.out.println("\n=== Registering Observers for Google Stock ===");
        googleStock.registerObserver(webApp1);
        googleStock.registerObserver(mobileApp2);
        
        System.out.println("\n=== Registering Observers for Tesla Stock ===");
        teslaStock.registerObserver(webApp2);
        teslaStock.registerObserver(mobileApp1);
        
        System.out.println("\n=== Updating Stock Prices ===");
        
        // Update Apple stock price multiple times
        System.out.println("\n--- Apple Stock Updates ---");
        appleStock.setStockPrice(180.75);
        appleStock.setStockPrice(190.50);
        
        // Update Google stock price
        System.out.println("\n--- Google Stock Updates ---");
        googleStock.setStockPrice(2900.00);
        
        // Update Tesla stock price
        System.out.println("\n--- Tesla Stock Updates ---");
        teslaStock.setStockPrice(800.00);
        
        System.out.println("\n=== Removing an Observer from Apple Stock ===");
        appleStock.deregisterObserver(mobileApp1);
        appleStock.setStockPrice(195.25);
        
        System.out.println("\n=== Final Status of All Observers ===");
        // Display which stocks each observer is monitoring
        System.out.println("Registered observers per stock:");
        displayStockObservers(appleStock, "Apple");
        displayStockObservers(googleStock, "Google");
        displayStockObservers(teslaStock, "Tesla");
    }
    
    private static void displayStockObservers(StockMarket stock, String stockName) {
        System.out.println("  - " + stockName + " stock: " + 
                          stock.getStockName() + " at $" + 
                          String.format("%.2f", stock.getStockPrice()));
    }
}
