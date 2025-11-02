package Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    List<AccountObserver> observers = new ArrayList<>();
    private double balance;

    // new observe add method
    public void attach(AccountObserver observer) {
        observers.add(observer);
    }
    // new observe remove method
    public void detach(AccountObserver observer) {
        observers.remove(observer);
    }
    // notify observers method is added in deposit
    public void deposit(double amount) {
        balance += amount;
        notifyObservers();
    }
    // notify observers method is added in withdraw
    public void withdraw(double amount) {
        balance -= amount;
        notifyObservers();
    }
    // notify all observers about balance change
    private void notifyObservers() {
        for (AccountObserver observer : observers) {
            observer.update(balance);
        }
    }
}
