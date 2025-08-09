package Lesson6_DependencyInversionPrinciple.Example1.ProblematicCode;

class PushService {
    public void sendPush(String message) {
        System.out.println("Sending push notification: " + message);
    }
}