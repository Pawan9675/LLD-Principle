// Step 5: How to use it (Example)
package Lesson2_OpenClosedPrinciple.Example3.BetterCode;

public class Main {
    public static void main(String[] args) {
        ReportGenerator generator = new ReportGenerator();
        
        // Create different report types
        Report pdfReport = new PDFReport();
        Report wordReport = new WordReport();
        
        // Generate reports
        System.out.println(generator.generateReport(pdfReport));   // "Generating PDF report."
        System.out.println(generator.generateReport(wordReport));  // "Generating Word report."
    }
}