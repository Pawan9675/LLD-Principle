package Lesson4_LiskovSubstitutionPrinciple.Example2.BetterCode;

public class Vendor extends Employee implements PayableEmployee {

    private double contractAmount;

    public Vendor(String name, String empId, double contractAmount) {
        super(name, empId);
        this.contractAmount = contractAmount;
    }

    @Override
    public double calculateSalary() {
        return contractAmount;
    }
}
