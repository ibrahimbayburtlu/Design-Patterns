package Structural.Decorator;

public class MainDecoratorApp {
    public  static void main(String[] args) {
        Notifier notifier = new SlackNotifier(new SMSNotifier(new EmailNotifier()));
        notifier.send("Hello, Decorator Pattern!");
    }
}
