package Lesson4_LiskovSubstitutionPrinciple.Example2.ProblematicCode;

public class Volunteer extends Employee {

    public Volunteer(String name, String empId) {
        super(name, empId);
    }

    @Override
    public double calculateSalary() {
        // ❌ Volunteers don't get paid – but we are forced to implement
        // either return 0 or throw exception — both are bad design
        return 0.0;
        // throw new UnsupportedOperationException("Volunteer has no salary");
    }
}
