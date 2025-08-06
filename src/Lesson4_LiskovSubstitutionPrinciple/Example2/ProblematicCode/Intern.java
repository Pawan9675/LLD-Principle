package Lesson4_LiskovSubstitutionPrinciple.Example2.ProblematicCode;

public class Intern extends Employee {

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
