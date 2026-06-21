package Week1.ObserverPatternExample.src;
// src/WebApp.java
public class WebApp implements Observer {
    private String webAppName;

    public WebApp() {
        this.webAppName = "Web App v1.0";
    }

    public WebApp(String webAppName) {
        this.webAppName = webAppName;
    }

    // Implement the Observer interface method with signature (String, double)
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("🌐 [WebApp] Update: " + stockName + " is now $" + String.format("%.2f", stockPrice));

        // Additional logic for web app
        if (stockPrice < 100) {
            System.out.println("🌐 Special: Stock price is low - consider buying!");
        }
    }

    // Keep convenience overload if other parts of code pass a Stock object
    public void update(Stock stock) {
        if (stock == null) return;
        update(stock.getStockName(), stock.getStockPrice());
    }

    public String getWebAppName() {
        return webAppName;
    }
}