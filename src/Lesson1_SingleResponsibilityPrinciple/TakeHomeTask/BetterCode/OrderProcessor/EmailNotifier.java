// EmailNotifier.java
package Lesson1_SingleResponsibilityPrinciple.TakeHomeTask.BetterCode.OrderProcessor;

public class EmailNotifier {
    public void sendEmailNotification(User user) {
        // Only responsible for sending email notifications
        System.out.println("Email sent to user.");
    }
}
