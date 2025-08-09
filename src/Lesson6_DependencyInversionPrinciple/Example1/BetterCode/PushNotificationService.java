package Lesson6_DependencyInversionPrinciple.Example1.BetterCode;

class PushNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending push notification: " + message);
    }
}