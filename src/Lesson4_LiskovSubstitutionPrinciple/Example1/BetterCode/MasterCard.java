// File: MasterCard.java
package Lesson4_LiskovSubstitutionPrinciple.Example1.BetterCode;

// MasterCard implements international payment capability
public class MasterCard extends CreditCard implements InternationalPaymentCompatibleCreditCard {
    
    @Override
    public void tapAndPay() {
        System.out.println("Tap and Pay impl of MasterCard");
    }

    @Override
    public void onlineTransfer() {
        System.out.println("Online Transfer impl of MasterCard");
    }

    @Override
    public void swipeAndPay() {
        System.out.println("Swipe and Pay impl of MasterCard");
    }

    @Override
    public void mandatePayments() {
        System.out.println("Mandate payment impl of MasterCard");
    }

    // SOLUTION: Only implement what MasterCard actually supports
    @Override
    public void internationalPayment() {
        System.out.println("International payment impl of MasterCard");
    }
    
    // No upiPayment() method - MasterCard doesn't claim to support UPI
}