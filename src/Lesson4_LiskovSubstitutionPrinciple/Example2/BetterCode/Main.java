package Lesson4_LiskovSubstitutionPrinciple.Example2.BetterCode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PayableEmployee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("Rahul", "EMP001", 40000, 10000));
        employees.add(new Intern("Aditi", "EMP002", 15000));
        employees.add(new Vendor("Ravi", "EMP003", 30000));

        SalaryDisburser disburser = new SalaryDisburser();
        disburser.disburseSalaries(employees);

        // ✅ No volunteer in this list — no issue with salary disbursement
    }
}
