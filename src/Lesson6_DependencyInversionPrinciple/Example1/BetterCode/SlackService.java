package Lesson6_DependencyInversionPrinciple.Example1.BetterCode;

class SlackService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}