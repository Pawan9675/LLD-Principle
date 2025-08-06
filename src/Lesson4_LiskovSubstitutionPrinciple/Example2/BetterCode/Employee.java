package Lesson4_LiskovSubstitutionPrinciple.Example2.BetterCode;

public abstract class Employee {

    private String name;
    private String empId;

    public Employee(String name, String empId) {
        this.name = name;
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public String getEmpId() {
        return empId;
    }
}
