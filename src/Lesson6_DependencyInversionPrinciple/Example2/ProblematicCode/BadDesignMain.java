package Lesson6_DependencyInversionPrinciple.Example2.ProblematicCode;

// Main class for BAD design
class BadDesignMain {
    public static void main(String[] args) {
        System.out.println("=== BAD DESIGN EXAMPLE ===");
        
        // Multiple dependencies, separate methods for each
        OrderService badService = new OrderService();
        badService.saveToMySQL("Laptop");
        badService.saveToPostgreSQL("Mouse");
        badService.saveToOracle("Keyboard");
        
        System.out.println("\nProblems with Bad Design:");
        System.out.println("❌ Need separate methods for each database");
        System.out.println("❌ Can't easily switch database types");
        System.out.println("❌ Hard to test without real databases");
        System.out.println("❌ Need to modify OrderService class to add new databases");
        System.out.println("❌ Tightly coupled - creates dependencies internally");
    }
}