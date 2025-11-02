package Behavioral.Observer;

import Structural.Decorator.EmailNotifier;

public class Main {
    public  static void main(String[] args) {
        BankAccount account = new BankAccount();

        AccountObserver emailNotifier = new EmailService();
        AccountObserver smsNotifier = new SmsService();
        AccountObserver analyticsService = new AnalyticsService();

        account.attach(emailNotifier);
        account.attach(smsNotifier);

        account.deposit(500.0);
        account.deposit(200.0);

        account.detach(emailNotifier);
        account.detach(smsNotifier);
        account.detach(analyticsService);
        account.withdraw(300.0);
    }
}
