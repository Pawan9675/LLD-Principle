// Step 1: Create the Report interface (The Rule ALL reports must follow)
package Lesson2_OpenClosedPrinciple.Example3.BetterCode;

public interface Report {
    String generate();  // Every report must know how to generate itself!
}