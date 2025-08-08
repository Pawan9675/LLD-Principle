// CheckingAccount.java - Example of flexible combinations
package Lesson5_InterfaceSegregationPrinciple.Example2.BetterCode;

public class CheckingAccount implements IAccount, IDeposit, IWithdraw {
    private double balance = 2000.0; // Starting with $2000
    
    @Override
    public double checkBalance() {
        System.out.println("💳 Checking Account Balance: $" + balance);
        return balance;
    }
    
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("💰 Deposited $" + amount + " to Checking. New balance: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        // Checking accounts allow overdraft
        balance -= amount;
        System.out.println("💸 Withdrew $" + amount + " from Checking. New balance: $" + balance);
        if (balance < 0) {
            System.out.println("⚠️ Account is overdrawn!");
        }
    }
}