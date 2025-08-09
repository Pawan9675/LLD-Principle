package Lesson6_DependencyInversionPrinciple.Example2.BetterCode;

// High-level module depending on abstraction
class OrderServiceGood {
    private Database database; // Depends on interface!
    
    // Constructor injection
    public OrderServiceGood(Database database) {
        this.database = database;
    }
    
    public void placeOrder(String order) {
        database.saveOrder(order);
    }
}