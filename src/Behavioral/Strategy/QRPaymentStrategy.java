package Behavioral.Strategy;

public class QRPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("QR Code Payment Strategy used to pay: $" + amount);
        // API Call to process QR code payment would go here
        // For demonstration, we just print a message
        // e.g., QRCodeAPI.processPayment(qrCodeData, amount);
    }
}
