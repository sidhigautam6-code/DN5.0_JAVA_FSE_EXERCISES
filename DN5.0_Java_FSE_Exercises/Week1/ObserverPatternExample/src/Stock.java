package Week1.ObserverPatternExample.src;
// src/Stock.java

interface Observer {

    void update(Stock stock);

    void update(String stockName, double stockPrice);
}

public interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
    String getStockName();
    double getStockPrice();
}
