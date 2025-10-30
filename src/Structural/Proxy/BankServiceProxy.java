package Structural.Proxy;

public class BankServiceProxy implements BankService {

    private RealBankService realBankService;

    @Override
    public void withdraw(String userRole, double amount) {
        if (!userRole.equalsIgnoreCase("admin")) {
            System.out.println("Erişim reddedildi. Yetersiz yetki.");
        } else {
            if (realBankService == null) {
                realBankService = new RealBankService();
            }
            System.out.println("Erişim onaylandı. İşlem gerçekleştiriliyor...");
            realBankService.withdraw(userRole, amount);
        }
    }
}
