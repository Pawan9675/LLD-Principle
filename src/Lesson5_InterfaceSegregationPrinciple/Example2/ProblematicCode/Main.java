// Main.java - Problematic usage
package Lesson5_InterfaceSegregationPrinciple.Example2.ProblematicCode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== BAD DESIGN - BANK ACCOUNT EXAMPLE ===");
        
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount());
        accounts.add(new FixedDepositAccount());
        accounts.add(new LoanAccount());
        
        for (Account account : accounts) {
            String accountType = account.getClass().getSimpleName();
            System.out.println("\n--- Testing " + accountType + " ---");
            
            // This always works
            account.checkBalance();
            
            // ❌ PROBLEM: These operations might throw exceptions!
            try {
                account.deposit(100);
            } catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            }
            
            try {
                account.withdraw(50);
            } catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            }
            
            try {
                account.payEMI(200);
            } catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            }
            
            try {
                account.getMaturityPeriod();
            } catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println("\n❌ PROBLEMS WITH THIS DESIGN:");
        System.out.println("1. Many methods throw exceptions");
        System.out.println("2. Code is full of try-catch blocks");
        System.out.println("3. Not clear what each account can actually do");
        System.out.println("4. Forced to implement methods that don't make sense");
    }
}