package Creational.Factory;

public class IsBankPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("İş Bankası üzerinden " + amount + " TL ödeme yapıldı.");
    }
}
