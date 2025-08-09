package Lesson6_DependencyInversionPrinciple.Example2.BetterCode;

// Main class for GOOD design
class GoodDesignMain {
    public static void main(String[] args) {
        System.out.println("=== GOOD DESIGN EXAMPLE ===");
        
        // Easy to switch implementations
        Database mysqlDb = new MySQLDatabaseGood();
        OrderServiceGood service1 = new OrderServiceGood(mysqlDb);
        service1.placeOrder("Laptop");
        
        // Switch to PostgreSQL without changing OrderServiceGood
        Database postgresDb = new PostgreSQLDatabase();
        OrderServiceGood service2 = new OrderServiceGood(postgresDb);
        service2.placeOrder("Mouse");
        
        // Switch to Oracle without changing OrderServiceGood
        Database oracleDb = new OracleDatabase();
        OrderServiceGood service3 = new OrderServiceGood(oracleDb);
        service3.placeOrder("Keyboard");
        
        // Add new database (MongoDB) without modifying OrderServiceGood!
        Database mongoDb = new MongoDB();
        OrderServiceGood service4 = new OrderServiceGood(mongoDb);
        service4.placeOrder("Monitor");
        
        System.out.println("\nBenefits of Good Design:");
        System.out.println("✅ Single method works with any database type");
        System.out.println("✅ Easy to switch between different implementations");
        System.out.println("✅ Easy to test with mock objects");
        System.out.println("✅ Can add new databases without modifying existing code");
        System.out.println("✅ Loosely coupled - dependencies injected from outside");
    }
}