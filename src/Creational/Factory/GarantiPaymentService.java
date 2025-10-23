package Creational.Factory;

public class GarantiPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("Garanti Bankası üzerinden " + amount + " TL ödeme yapıldı.");
    }
}
