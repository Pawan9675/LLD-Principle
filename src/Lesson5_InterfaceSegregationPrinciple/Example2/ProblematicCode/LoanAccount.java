// LoanAccount.java - PROBLEM: Can't deposit but forced to implement
package Lesson5_InterfaceSegregationPrinciple.Example2.ProblematicCode;

public class LoanAccount implements Account {
    private double loanAmount = 10000.0; // We owe $10,000
    
    @Override
    public void deposit(double amount) {
        // ❌ PROBLEM: You can't deposit money into a loan account! But we're forced to implement!
        throw new UnsupportedOperationException("❌ Cannot deposit money into loan account!");
    }

    @Override
    public void withdraw(double amount) {
        // ❌ PROBLEM: You can't withdraw from loan account! But we're forced to implement!
        throw new UnsupportedOperationException("❌ Cannot withdraw money from loan account!");
    }

    @Override
    public double checkBalance() {
        System.out.println("💳 Loan Account - Amount Owed: $" + loanAmount);
        return loanAmount;
    }

    @Override
    public void payEMI(double amount) {
        loanAmount -= amount;
        System.out.println("💸 Paid EMI of $" + amount + ". Remaining loan: $" + loanAmount);
    }

    @Override
    public int getMaturityPeriod() {
        // ❌ PROBLEM: Loans don't have maturity, they have payment period! But we're forced to implement!
        throw new UnsupportedOperationException("❌ Loan accounts don't have maturity period!");
    }
}