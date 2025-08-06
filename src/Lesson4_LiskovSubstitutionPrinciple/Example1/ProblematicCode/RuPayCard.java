// File: RuPayCard.java
package Lesson4_LiskovSubstitutionPrinciple.Example1.ProblematicCode;

public class RuPayCard extends CreditCard {
    @Override
    public void tapAndPay() {
        System.out.println("Tap and Pay impl of RuPay");
    }

    @Override
    public void onlineTransfer() {
        System.out.println("Online Transfer impl of RuPay");
    }

    @Override
    public void swipeAndPay() {
        System.out.println("Swipe and Pay impl of RuPay");
    }

    @Override
    public void mandatePayments() {
        System.out.println("Mandate payment impl of RuPay");
    }

    @Override
    public void upiPayment() {
        System.out.println("UPI payment impl of RuPay");
    }

    @Override
    public void intlPayment() {
        // PROBLEM: RuPay doesn't support international payments but forced to implement
        // RuPay is "Made in India" and many countries don't support it
        // Option 1: Empty implementation
        // Option 2: throw new UnsupportedOperationException("RuPay doesn't support international payments");
    }
}