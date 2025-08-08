// IMaturity.java - For accounts that have expiration dates
package Lesson5_InterfaceSegregationPrinciple.Example2.BetterCode;

public interface IMaturity {
    int getMaturityPeriod(); // Only accounts that expire after some time
}