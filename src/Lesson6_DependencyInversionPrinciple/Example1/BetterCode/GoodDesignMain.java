package Lesson6_DependencyInversionPrinciple.Example1.BetterCode;

// Main class for GOOD design
class GoodDesignMain {
    public static void main(String[] args) {
        System.out.println("=== GOOD DESIGN EXAMPLE ===");
        
        // Easy to switch implementations
        NotificationService emailService = new EmailService();
        NotificationManagerGood manager1 = new NotificationManagerGood(emailService);
        manager1.sendAlert("Hello via Email!");
        
        // Switch to SMS without changing NotificationManagerGood
        NotificationService smsService = new SMSService();
        NotificationManagerGood manager2 = new NotificationManagerGood(smsService);
        manager2.sendAlert("Hello via SMS!");
        
        // Switch to Push without changing NotificationManagerGood
        NotificationService pushService = new PushNotificationService();
        NotificationManagerGood manager3 = new NotificationManagerGood(pushService);
        manager3.sendAlert("Hello via Push!");
        
        // Add new service (Slack) without modifying NotificationManagerGood!
        NotificationService slackService = new SlackService();
        NotificationManagerGood manager4 = new NotificationManagerGood(slackService);
        manager4.sendAlert("Hello via Slack!");
        
        System.out.println("\nBenefits of Good Design:");
        System.out.println("✅ Single method works with any notification type");
        System.out.println("✅ Easy to switch between different implementations");
        System.out.println("✅ Easy to test with mock objects");
        System.out.println("✅ Can add new services without modifying existing code");
        System.out.println("✅ Loosely coupled - dependencies injected from outside");
    }
}