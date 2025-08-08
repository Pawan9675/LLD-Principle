// FixedDepositAccount.java - PROBLEM: Can't withdraw but forced to implement
package Lesson5_InterfaceSegregationPrinciple.Example2.ProblematicCode;

public class FixedDepositAccount implements Account {
    private double balance = 5000.0; // Starting with $5000 fixed deposit
    
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("💰 Added $" + amount + " to Fixed Deposit Account");
    }

    @Override
    public void withdraw(double amount) {
        // ❌ PROBLEM: FD accounts don't allow withdrawal before maturity! But we're forced to implement!
        throw new UnsupportedOperationException("❌ Cannot withdraw from Fixed Deposit before maturity!");
    }

    @Override
    public double checkBalance() {
        System.out.println("🏦 Fixed Deposit Balance: $" + balance);
        return balance;
    }

    @Override
    public void payEMI(double amount) {
        // ❌ PROBLEM: FD accounts don't pay EMI! But we're forced to implement!
        throw new UnsupportedOperationException("❌ Fixed Deposit accounts cannot pay EMI!");
    }

    @Override
    public int getMaturityPeriod() {
        System.out.println("⏰ Fixed Deposit matures in 24 months");
        return 24; // 2 years
    }
}