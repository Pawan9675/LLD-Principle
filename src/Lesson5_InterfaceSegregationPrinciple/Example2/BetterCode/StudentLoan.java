// StudentLoan.java - Another example showing flexibility
package Lesson5_InterfaceSegregationPrinciple.Example2.BetterCode;

public class StudentLoan implements IAccount, ILoan, IDeposit {
    private double loanAmount = 15000.0; // We owe $15,000
    
    @Override
    public double checkBalance() {
        System.out.println("🎓 Student Loan - Amount Owed: $" + loanAmount);
        return loanAmount;
    }

    @Override
    public void payEMI(double amount) {
        loanAmount -= amount;
        System.out.println("📚 Paid student loan EMI of $" + amount + ". Remaining: $" + loanAmount);
    }
    
    @Override
    public void deposit(double amount) {
        // Student loans allow extra payments to reduce principal
        loanAmount -= amount;
        System.out.println("💰 Made extra payment of $" + amount + ". Remaining loan: $" + loanAmount);
    }
}