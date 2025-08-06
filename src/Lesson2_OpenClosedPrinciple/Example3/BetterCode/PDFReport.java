// Step 2: PDF Report Class
package Lesson2_OpenClosedPrinciple.Example3.BetterCode;

public class PDFReport implements Report {
    @Override
    public String generate() {
        return "Generating PDF report.";
    }
}