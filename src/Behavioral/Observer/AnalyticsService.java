package Behavioral.Observer;

public class AnalyticsService implements AccountObserver {
    @Override
    public void update(double newBalance) {
        System.out.println("Analytics updated: New balance is " + newBalance);
    }
}
