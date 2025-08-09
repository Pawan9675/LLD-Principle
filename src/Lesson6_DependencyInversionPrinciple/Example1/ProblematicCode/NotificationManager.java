package Lesson6_DependencyInversionPrinciple.Example1.ProblematicCode;

// High-level module depending on low-level modules
class NotificationManager {
    private EmailService emailService; // Direct dependency!
    private SMSService smsService;   // Direct dependency!
    private PushService pushService; // Direct dependency!
    
    public NotificationManager() {
        this.emailService = new EmailService(); // Tightly coupled
        this.smsService = new SMSService();   // Tightly coupled
        this.pushService = new PushService(); // Tightly coupled
    }
    
    // Need separate methods for each service type
    public void sendEmailNotification(String message) {
        emailService.sendEmail(message);
    }
    
    public void sendSMSNotification(String message) {
        smsService.sendSMS(message);
    }
    
    public void sendPushNotification(String message) {
        pushService.sendPush(message);
    }
    
    // What if we want to add Slack? Need to modify this class!
}