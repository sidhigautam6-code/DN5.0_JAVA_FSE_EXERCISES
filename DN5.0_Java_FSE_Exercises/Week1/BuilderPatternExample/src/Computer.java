package Week1.BuilderPatternExample.src;
// src/Computer.java
public class Computer {
    // Required parameters
    private String cpu;
    private String ram;
    
    // Optional parameters
    private String storage;
    private String graphicsCard;
    private boolean bluetooth;
    private boolean wifi;
    
    // Private constructor taking Builder as parameter
    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.bluetooth = builder.bluetooth;
        this.wifi = builder.wifi;
    }
    
    // Getter methods
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public boolean hasBluetooth() { return bluetooth; }
    public boolean hasWifi() { return wifi; }
    
    @Override
    public String toString() {
        return "Computer [CPU=" + cpu + ", RAM=" + ram + 
               ", Storage=" + storage + ", Graphics=" + graphicsCard +
               ", Bluetooth=" + bluetooth + ", WiFi=" + wifi + "]";
    }
    
    // Static nested Builder class
    public static class ComputerBuilder {
        // Required parameters
        private String cpu;
        private String ram;
        
        // Optional parameters - initialized to default values
        private String storage = "256GB SSD";
        private String graphicsCard = "Integrated";
        private boolean bluetooth = false;
        private boolean wifi = false;
        
        public ComputerBuilder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }
        
        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }
        
        public ComputerBuilder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }
        
        public ComputerBuilder setBluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }
        
        public ComputerBuilder setWifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }
        
        public Computer build() {
            return new Computer(this);
        }
    }
}
