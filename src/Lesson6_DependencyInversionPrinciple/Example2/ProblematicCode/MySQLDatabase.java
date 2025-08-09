package Lesson6_DependencyInversionPrinciple.Example2.ProblematicCode;

// Low-level modules
class MySQLDatabase {
    public void saveOrder(String order) {
        System.out.println("Saving order to MySQL DB: " + order);
    }
}