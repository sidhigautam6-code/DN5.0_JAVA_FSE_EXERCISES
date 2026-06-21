package Week1.ProxyPatternExample.src;
// src/ProxyImage.java
public class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;
    
    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public void display() {
        // Lazy initialization: only load the image when needed
        if (realImage == null) {
            System.out.println("Proxy: Loading image for the first time...");
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
