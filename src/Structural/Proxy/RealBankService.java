package Structural.Proxy;

public class RealBankService implements BankService {
    @Override
    public void withdraw(String userRole, double amount) {
        System.out.println("Withdrawal of $" + amount + " processed for user with role: " + userRole);
    }
}
