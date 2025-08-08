// User.java - Problematic Interface (Forces all classes to implement all methods)
package Lesson5_InterfaceSegregationPrinciple.Example1.ProblematicCode;

public interface User {
    boolean canBuyProducts();
    boolean canModifyProducts();
    boolean canAddProducts();
    boolean canApproveProducts();
    void approveProduct();
    void buyProduct();
    void addProduct();
    void modifyProduct();
}