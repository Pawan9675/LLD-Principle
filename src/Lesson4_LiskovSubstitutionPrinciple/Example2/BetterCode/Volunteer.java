package Lesson4_LiskovSubstitutionPrinciple.Example2.BetterCode;

public class Volunteer extends Employee {
    public Volunteer(String name, String empId) {
        super(name, empId);
    }

    // No salary logic here — perfectly fine!
}
