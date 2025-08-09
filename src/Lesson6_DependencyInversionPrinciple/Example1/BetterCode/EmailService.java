package Lesson6_DependencyInversionPrinciple.Example1.BetterCode;

// Low-level modules implementing the interface
class EmailService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
}