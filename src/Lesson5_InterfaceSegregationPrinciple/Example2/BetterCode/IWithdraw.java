// IWithdraw.java - For accounts that allow withdrawals
package Lesson5_InterfaceSegregationPrinciple.Example2.BetterCode;

public interface IWithdraw {
    void withdraw(double amount); // Only accounts you can take money from
}