package Week1.DecoratorPatternExample;
// src/TestDecorator.java
public class TestDecorator {
    public static void main(String[] args) {
        // Basic email notifier
        Notifier emailNotifier = new EmailNotifier();
        System.out.println("Basic email notification:");
        emailNotifier.send("Hello World!");
        
        System.out.println("\nEmail + SMS notification:");
        Notifier emailAndSMS = new SMSNotifierDecorator(emailNotifier);
        emailAndSMS.send("Hello World!");
        
        System.out.println("\nEmail + SMS + Slack notification:");
        Notifier emailSMSAndSlack = new SlackNotifierDecorator(
                new SMSNotifierDecorator(emailNotifier));
        emailSMSAndSlack.send("Hello World!");
    }
}
