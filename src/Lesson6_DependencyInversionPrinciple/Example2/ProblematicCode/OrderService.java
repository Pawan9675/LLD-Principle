package Lesson6_DependencyInversionPrinciple.Example2.ProblematicCode;

// High-level module depending on low-level modules
class OrderService {
    private MySQLDatabase mysqlDatabase;       // Direct dependency!
    private PostgreSQLDatabaseBad postgresDatabase; // Direct dependency!
    private OracleDatabaseBad oracleDatabase;       // Direct dependency!
    
    public OrderService() {
        this.mysqlDatabase = new MySQLDatabase();           // Tightly coupled
        this.postgresDatabase = new PostgreSQLDatabaseBad(); // Tightly coupled
        this.oracleDatabase = new OracleDatabaseBad();       // Tightly coupled
    }
    
    // Need separate methods for each database type
    public void saveToMySQL(String order) {
        mysqlDatabase.saveOrder(order);
    }
    
    public void saveToPostgreSQL(String order) {
        postgresDatabase.saveOrder(order);
    }
    
    public void saveToOracle(String order) {
        oracleDatabase.saveOrder(order);
    }
    
    // What if we want to add MongoDB? Need to modify this class!
}