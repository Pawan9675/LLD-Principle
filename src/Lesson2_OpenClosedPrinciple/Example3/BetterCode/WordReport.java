// Step 3: Word Report Class  
package Lesson2_OpenClosedPrinciple.Example3.BetterCode;

public class WordReport implements Report {
    @Override
    public String generate() {
        return "Generating Word report.";
    }
}