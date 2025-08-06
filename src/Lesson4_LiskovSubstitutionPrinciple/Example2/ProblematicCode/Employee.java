package Lesson4_LiskovSubstitutionPrinciple.Example2.ProblematicCode;

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

    // ❌ Violates LSP: forcing all subclasses to implement this
    public abstract double calculateSalary();
}
