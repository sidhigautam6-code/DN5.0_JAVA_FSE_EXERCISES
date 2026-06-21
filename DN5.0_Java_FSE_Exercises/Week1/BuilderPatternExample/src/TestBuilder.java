package Week1.BuilderPatternExample.src;
// src/TestBuilder.java
public class TestBuilder {
    public static void main(String[] args) {
        // Build a basic computer
        Computer basicComputer = new Computer.ComputerBuilder("Intel i5", "8GB")
                .build();
        
        // Build a gaming computer
        Computer gamingComputer = new Computer.ComputerBuilder("Intel i9", "32GB")
                .setStorage("1TB NVMe SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setBluetooth(true)
                .setWifi(true)
                .build();
        
        // Build an office computer
        Computer officeComputer = new Computer.ComputerBuilder("Intel i3", "16GB")
                .setStorage("512GB SSD")
                .setBluetooth(true)
                .build();
        
        // Display configurations
        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
    }
}
