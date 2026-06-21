package Week1.CommandPatternExample;
// src/RemoteControl.java
public class RemoteControl {
    private Command command;
    
    public RemoteControl(Command command) {
        this.command = command;
    }
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set");
        }
    }
}
