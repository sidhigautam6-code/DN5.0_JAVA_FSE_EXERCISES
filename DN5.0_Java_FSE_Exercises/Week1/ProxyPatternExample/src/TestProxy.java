package Week1.ProxyPatternExample.src;
// src/TestProxy.java
public class TestProxy {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");
        Image image3 = new ProxyImage("photo1.jpg"); // Same as image1
        
        System.out.println("Image objects created. No actual loading yet...");
        
        // Display images - this will trigger loading
        System.out.println("\nFirst display of image1:");
        image1.display();
        
        System.out.println("\nSecond display of image1 (should be cached):");
        image1.display();
        
        System.out.println("\nFirst display of image2:");
        image2.display();
        
        System.out.println("\nDisplay of image3 (same as image1):");
        image3.display();
    }
}