package Behavioral.Strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Credit Card Payment Strategy used to pay: $" + amount);
        // API Call to process credit card payment would go here
        // For demonstration, we just print a message
        // e.g., CreditCardAPI.processPayment(cardDetails, amount);
    }
}
