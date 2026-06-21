package Week1.CommandPatternExample;
// src/TestCommand.java
public class TestCommand {
    public static void main(String[] args) {
        // Create receiver
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        
        // Create commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command kitchenOn = new LightOnCommand(kitchenLight);
        
        // Create invoker
        RemoteControl remote = new RemoteControl(lightOn);
        
        // Test remote
        System.out.println("Turning on living room light:");
        remote.pressButton();
        
        System.out.println("\nTurning off living room light:");
        remote.setCommand(lightOff);
        remote.pressButton();
        
        System.out.println("\nTurning on kitchen light:");
        remote.setCommand(kitchenOn);
        remote.pressButton();
        
        // Demo: Execute commands directly
        System.out.println("\nDirect Command Execution:");
        lightOn.execute();
        lightOff.execute();
    }
}
