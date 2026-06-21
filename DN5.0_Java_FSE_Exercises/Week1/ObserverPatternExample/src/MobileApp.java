package Week1.ObserverPatternExample.src;
// src/MobileApp.java

interface Observer {
    void update(String stockName, double stockPrice);
}

public class MobileApp implements Observer {
    private String appName;
    
    public MobileApp() {
        this.appName = "Mobile App v2.0";
    }
    
    public MobileApp(String appName) {
        this.appName = appName;
    }
    
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("📱 [MobileApp] Alert: " + stockName + 
                          " price updated to $" + String.format("%.2f", stockPrice));
        
        // Additional logic for mobile app
        if (stockPrice > 1000) {
            System.out.println("📱 Warning: Stock price is very high!");
        }
    }
    
    public String getAppName() {
        return appName;
    }
}
