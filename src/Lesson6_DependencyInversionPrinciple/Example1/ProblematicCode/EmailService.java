package Lesson6_DependencyInversionPrinciple.Example1.ProblematicCode;

class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}