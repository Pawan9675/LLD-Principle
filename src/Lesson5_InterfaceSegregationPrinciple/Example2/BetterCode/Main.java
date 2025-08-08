// Main.java - Clean, safe usage
package Lesson5_InterfaceSegregationPrinciple.Example2.BetterCode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== GOOD DESIGN - BANK ACCOUNT EXAMPLE ===");
        
        // Create different types of accounts
        SavingsAccount savings = new SavingsAccount();
        FixedDepositAccount fixedDeposit = new FixedDepositAccount();
        LoanAccount loan = new LoanAccount();
        CheckingAccount checking = new CheckingAccount();
        StudentLoan studentLoan = new StudentLoan();
        
        System.out.println("\n--- Individual Account Operations ---");
        
        // ✅ BENEFIT: Each account can only do what it's supposed to do
        savings.deposit(100);
        savings.withdraw(50);
        savings.checkBalance();
        
        fixedDeposit.deposit(500);
        // fixedDeposit.withdraw(100); // ❌ Won't compile! FD can't withdraw
        fixedDeposit.getMaturityPeriod();
        
        loan.payEMI(300);
        // loan.deposit(100); // ❌ Won't compile! Regular loans can't accept deposits
        loan.checkBalance();
        
        studentLoan.payEMI(200);
        studentLoan.deposit(150); // ✅ Student loans CAN accept extra payments
        
        System.out.println("\n--- Type-Safe Group Operations ---");
        
        // ✅ BENEFIT: Group operations are safe and clear
        List<IAccount> allAccounts = new ArrayList<>();
        allAccounts.add(savings);
        allAccounts.add(fixedDeposit);
        allAccounts.add(loan);
        allAccounts.add(checking);
        allAccounts.add(studentLoan);
        
        System.out.println("\n💳 Checking all account balances:");
        for (IAccount account : allAccounts) {
            account.checkBalance(); // Safe - everyone can check balance!
        }
        
        // Only accounts that can accept deposits
        List<IDeposit> depositAccounts = new ArrayList<>();
        depositAccounts.add(savings);
        depositAccounts.add(fixedDeposit);
        depositAccounts.add(checking);
        depositAccounts.add(studentLoan);
        // depositAccounts.add(loan); // ❌ Won't compile! Regular loans can't accept deposits
        
        System.out.println("\n💰 Making deposits to all deposit accounts:");
        for (IDeposit account : depositAccounts) {
            account.deposit(25); // Safe - everyone in this list can accept deposits!
        }
        
        // Only accounts that allow withdrawals
        List<IWithdraw> withdrawAccounts = new ArrayList<>();
        withdrawAccounts.add(savings);
        withdrawAccounts.add(checking);
        // withdrawAccounts.add(fixedDeposit); // ❌ Won't compile! FD can't withdraw
        // withdrawAccounts.add(loan); // ❌ Won't compile! Loans can't withdraw
        
        System.out.println("\n💸 Making withdrawals from withdrawal accounts:");
        for (IWithdraw account : withdrawAccounts) {
            account.withdraw(20); // Safe - everyone in this list allows withdrawals!
        }
        
        // Only accounts that have EMI payments
        List<ILoan> loanAccounts = new ArrayList<>();
        loanAccounts.add(loan);
        loanAccounts.add(studentLoan);
        // loanAccounts.add(savings); // ❌ Won't compile! Savings don't have EMI
        
        System.out.println("\n💸 Processing EMI payments:");
        for (ILoan loanAccount : loanAccounts) {
            loanAccount.payEMI(100); // Safe - everyone in this list has EMI!
        }
        
        // Only accounts that have maturity periods
        List<IMaturity> maturityAccounts = new ArrayList<>();
        maturityAccounts.add(fixedDeposit);
        // maturityAccounts.add(savings); // ❌ Won't compile! Savings don't mature
        
        System.out.println("\n⏰ Checking maturity periods:");
        for (IMaturity account : maturityAccounts) {
            account.getMaturityPeriod(); // Safe!
        }
        
        System.out.println("\n✅ BENEFITS OF THIS DESIGN:");
        System.out.println("1. No exceptions thrown - compile-time safety!");
        System.out.println("2. Crystal clear what each account type can do");
        System.out.println("3. No forced empty implementations");
        System.out.println("4. Easy to add new account types");
        System.out.println("5. Type-safe group operations");
        System.out.println("6. Code is clean and maintainable");
        
        System.out.println("\n🎯 INTERFACE SEGREGATION PRINCIPLE ACHIEVED!");
        System.out.println("Each interface represents ONE specific banking capability.");
        System.out.println("Accounts implement only the capabilities they actually have.");
        
        System.out.println("\n🤔 THINK ABOUT IT:");
        System.out.println("- Savings Account: Can deposit, withdraw, check balance");
        System.out.println("- Fixed Deposit: Can deposit, check balance, has maturity");
        System.out.println("- Loan Account: Can check balance, pay EMI");
        System.out.println("- Student Loan: Can check balance, pay EMI, accept extra payments");
        System.out.println("Each account type makes perfect sense!");
    }
}