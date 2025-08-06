// File: VisaCard.java
package Lesson4_LiskovSubstitutionPrinciple.Example1.BetterCode;

// VisaCard implements international payment capability
public class VisaCard extends CreditCard implements InternationalPaymentCompatibleCreditCard {
    
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

    // SOLUTION: Only implement what VisaCard actually supports
    @Override
    public void internationalPayment() {
        System.out.println("International payment impl of VISA");
    }
    
    // No upiPayment() method - VisaCard doesn't claim to support UPI
    // No forced implementation, no exceptions, no dummy methods
}