package Lesson6_DependencyInversionPrinciple.Example1.ProblematicCode;

class SMSService {
    public void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}