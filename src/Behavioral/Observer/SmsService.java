package Behavioral.Observer;

public class SmsService implements AccountObserver{
    public void update(double newBalance) {
        System.out.println("SMS sent: Your new balance is " + newBalance);
    }
}