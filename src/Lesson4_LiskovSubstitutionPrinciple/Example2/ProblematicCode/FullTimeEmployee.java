package Lesson4_LiskovSubstitutionPrinciple.Example2.ProblematicCode;

public class FullTimeEmployee extends Employee {

    private double baseSalary;
    private double bonus;

    public FullTimeEmployee(String name, String empId, double baseSalary, double bonus) {
        super(name, empId);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        // FTEs get base salary + bonus
        return baseSalary + bonus;
    }
}
