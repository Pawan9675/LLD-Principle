package Lesson4_LiskovSubstitutionPrinciple.Example2.BetterCode;

public class FullTimeEmployee extends Employee implements PayableEmployee {

    private double baseSalary;
    private double bonus;

    public FullTimeEmployee(String name, String empId, double baseSalary, double bonus) {
        super(name, empId);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}
