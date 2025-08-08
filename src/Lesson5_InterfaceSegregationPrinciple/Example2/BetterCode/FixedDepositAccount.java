// FixedDepositAccount.java - Only implements what it can do
package Lesson5_InterfaceSegregationPrinciple.Example2.BetterCode;

public class FixedDepositAccount implements IAccount, IDeposit, IMaturity {
    private double balance = 5000.0; // Starting with $5000 fixed deposit
    
    @Override
    public double checkBalance() {
        System.out.println("🏦 Fixed Deposit Balance: $" + balance);
        return balance;
    }
    
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("💰 Added $" + amount + " to Fixed Deposit. New balance: $" + balance);
    }

    @Override
    public int getMaturityPeriod() {
        System.out.println("⏰ Fixed Deposit matures in 24 months");
        return 24; // 2 years
    }
    
    // ✅ BENEFIT: No withdraw() or payEMI() methods! 
    // ✅ If you try to withdraw, it won't even compile!
}