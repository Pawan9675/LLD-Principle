package Lesson4_LiskovSubstitutionPrinciple.Example2.ProblematicCode;

public class Vendor extends Employee {

    private double monthlyContractAmount;

    public Vendor(String name, String empId, double monthlyContractAmount) {
        super(name, empId);
        this.monthlyContractAmount = monthlyContractAmount;
    }

    @Override
    public double calculateSalary() {
        return monthlyContractAmount;
    }
}
