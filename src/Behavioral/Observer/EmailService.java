package Behavioral.Observer;

public class EmailService implements AccountObserver {
    @Override
    public void update(double newBalance) {
        System.out.println("Email sent: Your new balance is " + newBalance);
    }
}
