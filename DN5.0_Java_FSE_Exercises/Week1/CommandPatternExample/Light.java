package Week1.CommandPatternExample;
// src/Light.java
public class Light {
    private String location;
    
    public Light(String location) {
        this.location = location;
    }
    
    public void turnOn() {
        System.out.println(location + " Light is turned ON");
    }
    
    public void turnOff() {
        System.out.println(location + " Light is turned OFF");
    }
}