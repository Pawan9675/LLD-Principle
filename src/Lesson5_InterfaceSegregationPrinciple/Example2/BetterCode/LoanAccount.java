// LoanAccount.java - Super clean, only loan operations
package Lesson5_InterfaceSegregationPrinciple.Example2.BetterCode;

public class LoanAccount implements IAccount, ILoan {
    private double loanAmount = 10000.0; // We owe $10,000
    
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
    
    // ✅ BENEFIT: No deposit(), withdraw(), or getMaturityPeriod() methods!
    // ✅ Clean and focused only on loan operations
}