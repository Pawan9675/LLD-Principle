// BONUS: Want to add Excel Report? NO PROBLEM! 🎉
// Just create this new class - DON'T touch ReportGenerator!
package Lesson2_OpenClosedPrinciple.Example3.BetterCode;

public class ExcelReport implements Report {
    @Override
    public String generate() {
        return "Generating Excel report.";
    }
}