package Lesson4_LiskovSubstitutionPrinciple.Example2.BetterCode;

import java.util.List;

public class SalaryDisburser {

    public void disburseSalaries(List<PayableEmployee> employees) {
        for (PayableEmployee emp : employees) {
            double salary = emp.calculateSalary();
            makePayment(emp, salary);
        }
    }

    private void makePayment(PayableEmployee emp, double amount) {
        System.out.println("Paid ₹" + amount + " to employee.");
    }
}
