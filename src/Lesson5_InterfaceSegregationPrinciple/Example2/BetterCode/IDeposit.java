// IDeposit.java - For accounts that accept deposits
package Lesson5_InterfaceSegregationPrinciple.Example2.BetterCode;

public interface IDeposit {
    void deposit(double amount); // Only accounts that can accept money
}