// File: RuPayCard.java
package Lesson4_LiskovSubstitutionPrinciple.Example1.BetterCode;

// RuPayCard implements UPI payment capability
public class RuPayCard extends CreditCard implements UpiCompatibleCreditCard {
    
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

    // SOLUTION: Only implement what RuPayCard actually supports
    @Override
    public void upiPayment() {
        System.out.println("UPI payment impl of RuPay");
    }
    
    // No internationalPayment() method - RuPayCard doesn't claim to support international payments
}