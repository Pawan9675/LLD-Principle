package Lesson6_DependencyInversionPrinciple.Example1.BetterCode;

class SMSService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}