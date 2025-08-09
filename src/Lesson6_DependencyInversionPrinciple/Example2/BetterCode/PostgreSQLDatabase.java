package Lesson6_DependencyInversionPrinciple.Example2.BetterCode;

class PostgreSQLDatabase implements Database {
    @Override
    public void saveOrder(String order) {
        System.out.println("Saving order to PostgreSQL DB: " + order);
    }
}