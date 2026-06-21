package Week1.SortingCustomerOrders;
// src/Order.java
public class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;
    private String orderDate;
    
    public Order(String orderId, String customerName, double totalPrice, String orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }
    
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }
    public String getOrderDate() { return orderDate; }
    
    @Override
    public String toString() {
        return String.format("Order[ID: %s, Customer: %s, Total: $%.2f, Date: %s]",
                           orderId, customerName, totalPrice, orderDate);
    }
}