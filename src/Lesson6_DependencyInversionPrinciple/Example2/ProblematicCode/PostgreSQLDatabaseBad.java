package Lesson6_DependencyInversionPrinciple.Example2.ProblematicCode;

class PostgreSQLDatabaseBad {
    public void saveOrder(String order) {
        System.out.println("Saving order to PostgreSQL DB: " + order);
    }
}