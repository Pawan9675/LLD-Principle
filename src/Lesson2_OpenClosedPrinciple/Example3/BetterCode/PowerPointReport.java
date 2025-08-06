// BONUS: PowerPoint Report? Easy! 
package Lesson2_OpenClosedPrinciple.Example3.BetterCode;

public class PowerPointReport implements Report {
    @Override
    public String generate() {
        return "Generating PowerPoint report.";
    }
}