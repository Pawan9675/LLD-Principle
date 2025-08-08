// SavingsAccount.java - PROBLEM: Forced to implement methods it can't use
package Lesson5_InterfaceSegregationPrinciple.Example2.ProblematicCode;

public class SavingsAccount implements Account {
    private double balance = 1000.0; // Starting with $1000
    
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("💰 Deposited $" + amount + " to Savings Account");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("💸 Withdrew $" + amount + " from Savings Account");
        } else {
            System.out.println("❌ Not enough money in Savings Account!");
        }
    }

    @Override
    public double checkBalance() {
        System.out.println("💳 Savings Account Balance: $" + balance);
        return balance;
    }

    @Override
    public void payEMI(double amount) {
        // ❌ PROBLEM: Savings accounts don't pay EMI! But we're forced to implement this!
        throw new UnsupportedOperationException("❌ Savings accounts cannot pay EMI!");
    }

    @Override
    public int getMaturityPeriod() {
        // ❌ PROBLEM: Savings accounts don't have maturity period! But we're forced to implement this!
        throw new UnsupportedOperationException("❌ Savings accounts don't have maturity period!");
    }
}