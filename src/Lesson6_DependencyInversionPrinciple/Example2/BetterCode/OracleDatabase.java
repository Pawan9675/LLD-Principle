package Lesson6_DependencyInversionPrinciple.Example2.BetterCode;

class OracleDatabase implements Database {
    @Override
    public void saveOrder(String order) {
        System.out.println("Saving order to Oracle DB: " + order);
    }
}