package Lesson4_LiskovSubstitutionPrinciple.Example2.BetterCode;

public class Intern extends Employee implements PayableEmployee {

    private double stipend;

    public Intern(String name, String empId, double stipend) {
        super(name, empId);
        this.stipend = stipend;
    }

    @Override
    public double calculateSalary() {
        return stipend;
    }
}
