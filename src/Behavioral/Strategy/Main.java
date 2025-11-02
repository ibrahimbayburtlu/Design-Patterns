package Behavioral.Strategy;

public class Main {
    public  static void main(String[] args) {
        POSTerminal terminal = new POSTerminal();
        terminal.setPaymentStrategy(new CreditCardPaymentStrategy());
        terminal.makePayment(250.0);

        terminal.setPaymentStrategy(new QRPaymentStrategy());
        terminal.makePayment(120.0);

        terminal.setPaymentStrategy(new InstallmentPaymentStrategy());
        terminal.makePayment(600.0);
    }
}
