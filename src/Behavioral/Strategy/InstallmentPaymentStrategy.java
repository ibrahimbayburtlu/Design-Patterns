package Behavioral.Strategy;

public class InstallmentPaymentStrategy implements  PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Installment Payment Strategy used to pay: $" + amount);
        // API Call to process installment payment would go here
        // For demonstration, we just print a message
        // e.g., InstallmentAPI.processPayment(installmentDetails, amount);
    }
}
