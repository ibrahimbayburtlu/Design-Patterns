package Creational.Factory;

public class PaymentFactory {

    public static PaymentService getPaymentService(String bankName) {
        return switch (bankName) {
            case "IsBank" -> new IsBankPaymentService();
            case "Garanti" -> new GarantiPaymentService();
            default -> throw new IllegalArgumentException("Bilinmeyen banka: " + bankName);
        };
    }
}
