package Lesson4_LiskovSubstitutionPrinciple.Example2.ProblematicCode;

import java.util.List;

public class SalaryDisburser {
    public void disburseSalaries(List<Employee> employees) {
        for (Employee emp : employees) {
            // ❌ LSP Violation: Volunteer doesn’t really belong in this loop
            double salary = emp.calculateSalary();
            makePayment(emp, salary);
        }
    }

    private void makePayment(Employee emp, double amount) {
        System.out.println("Paid ₹" + amount + " to " + emp.getName());
    }
}
