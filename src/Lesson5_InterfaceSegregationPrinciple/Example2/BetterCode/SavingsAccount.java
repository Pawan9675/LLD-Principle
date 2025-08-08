// SavingsAccount.java - Clean implementation, only what it needs
package Lesson5_InterfaceSegregationPrinciple.Example2.BetterCode;

public class SavingsAccount implements IAccount, IDeposit, IWithdraw {
    private double balance = 1000.0; // Starting with $1000
    
    @Override
    public double checkBalance() {
        System.out.println("💳 Savings Account Balance: $" + balance);
        return balance;
    }
    
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("💰 Deposited $" + amount + " to Savings Account. New balance: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("💸 Withdrew $" + amount + " from Savings. New balance: $" + balance);
        } else {
            System.out.println("❌ Not enough money in Savings Account!");
        }
    }
    
    // ✅ BENEFIT: No payEMI() or getMaturityPeriod() methods! Clean and clear.
}