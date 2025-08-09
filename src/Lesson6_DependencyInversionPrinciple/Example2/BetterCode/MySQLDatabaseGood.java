package Lesson6_DependencyInversionPrinciple.Example2.BetterCode;

// Low-level modules implementing the interface
class MySQLDatabaseGood implements Database {
    @Override
    public void saveOrder(String order) {
        System.out.println("Saving order to MySQL DB: " + order);
    }
}