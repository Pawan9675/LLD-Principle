// ILoan.java - For loan accounts
package Lesson5_InterfaceSegregationPrinciple.Example2.BetterCode;

public interface ILoan {
    void payEMI(double amount); // Only accounts that have EMI payments
}