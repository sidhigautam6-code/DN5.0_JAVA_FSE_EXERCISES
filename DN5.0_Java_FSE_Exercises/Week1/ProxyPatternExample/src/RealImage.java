package Week1.ProxyPatternExample.src;
// src/RealImage.java
public class RealImage implements Image {
    private String fileName;
    
    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();
    }
    
    private void loadFromServer() {
        System.out.println("Loading image " + fileName + " from remote server...");
        try {
            Thread.sleep(1000); // Simulate loading delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Image " + fileName + " loaded successfully.");
    }
    
    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}
