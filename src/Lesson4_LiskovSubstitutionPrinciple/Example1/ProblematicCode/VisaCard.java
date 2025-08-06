// File: VisaCard.java
package Lesson4_LiskovSubstitutionPrinciple.Example1.ProblematicCode;

public class VisaCard extends CreditCard {
    @Override
    public void tapAndPay() {
        System.out.println("Tap and Pay impl of VISA");
    }

    @Override
    public void onlineTransfer() {
        System.out.println("Online Transfer impl of VISA");
    }

    @Override
    public void swipeAndPay() {
        System.out.println("Swipe and Pay impl of VISA");
    }

    @Override
    public void mandatePayments() {
        System.out.println("Mandate payment impl of VISA");
    }

    @Override
    public void upiPayment() {
        // PROBLEM: Visa doesn't support UPI but forced to implement
        // Option 1: Empty implementation (misleading)
        // Option 2: throw new UnsupportedOperationException("Visa doesn't support UPI");
        // Both options are problematic - we're forced to implement something that shouldn't exist
    }

    @Override
    public void intlPayment() {
        System.out.println("Intl payment impl of VISA");
    }
}