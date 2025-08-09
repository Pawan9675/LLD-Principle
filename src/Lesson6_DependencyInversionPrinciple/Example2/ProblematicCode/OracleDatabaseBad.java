package Lesson6_DependencyInversionPrinciple.Example2.ProblematicCode;

class OracleDatabaseBad {
    public void saveOrder(String order) {
        System.out.println("Saving order to Oracle DB: " + order);
    }
}