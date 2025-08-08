// Account.java - PROBLEMATIC: One big interface forcing all behaviors
package Lesson5_InterfaceSegregationPrinciple.Example2.ProblematicCode;

public interface Account {
    void deposit(double amount);        // Put money in
    void withdraw(double amount);       // Take money out
    double checkBalance();              // See how much money you have
    void payEMI(double amount);         // Pay monthly loan payment
    int getMaturityPeriod();            // When does account expire (in months)
}