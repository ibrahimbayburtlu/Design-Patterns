package Behavioral.Strategy;

public class DebitCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Debit Card Payment Strategy used to pay: $" + amount);
        // API Call to process debit card payment would go here
        // For demonstration, we just print a message
        // e.g., DebitCardAPI.processPayment(cardDetails, amount);
    }
}
