package Creational.Factory;

public class PaymentApp {
    public static void main(String[] args) {
        PaymentService paymentService = PaymentFactory.getPaymentService("IsBank");
        paymentService.pay(150.0);

        paymentService = PaymentFactory.getPaymentService("Garanti");
        paymentService.pay(250.0);
    }
}
