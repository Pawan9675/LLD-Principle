package Lesson6_DependencyInversionPrinciple.Example1.BetterCode;

// High-level module depending on abstraction
class NotificationManagerGood {
    private NotificationService notificationService; // Depends on interface!
    
    // Constructor injection
    public NotificationManagerGood(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    
    public void sendAlert(String message) {
        notificationService.sendNotification(message);
    }
}