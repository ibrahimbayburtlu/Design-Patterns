package Structural.Proxy;

public class ProxyPatternMain {
    public static void main(String[] args) {
        BankService bankService = new BankServiceProxy();

        bankService.withdraw("USER", 500.0); // Access denied
        bankService.withdraw("ADMIN", 1000.0); // Withdrawal successful
    }
}
