package Lesson6_DependencyInversionPrinciple.Example1.ProblematicCode;

// Main class for BAD design
class BadDesignMain {
    public static void main(String[] args) {
        System.out.println("=== BAD DESIGN EXAMPLE ===");
        
        // Multiple dependencies, separate methods for each
        NotificationManager badManager = new NotificationManager();
        badManager.sendEmailNotification("Hello via Email!");
        badManager.sendSMSNotification("Hello via SMS!");
        badManager.sendPushNotification("Hello via Push!");
        
        System.out.println("\nProblems with Bad Design:");
        System.out.println("❌ Need separate methods for each service");
        System.out.println("❌ Can't easily switch notification types");
        System.out.println("❌ Hard to test without real services");
        System.out.println("❌ Need to modify NotificationManager class to add new services");
        System.out.println("❌ Tightly coupled - creates dependencies internally");
    }
}