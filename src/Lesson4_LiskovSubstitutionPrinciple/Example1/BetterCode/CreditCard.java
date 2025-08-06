// File: CreditCard.java
package Lesson4_LiskovSubstitutionPrinciple.Example1.BetterCode;

public abstract class CreditCard {

    private String ccNumber;
    private String ownerName;
    private int cvv;

    // Common setters - all credit cards have these properties
    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }
    
    public void setCVV(int cvv) {
        this.cvv = cvv;
    }
    
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // SOLUTION: Only include methods that ALL credit cards support
    public abstract void tapAndPay();
    public abstract void onlineTransfer();
    public abstract void swipeAndPay();
    public abstract void mandatePayments();
    
    // Removed upiPayment() and intlPayment() from base class
    // These are now handled by separate interfaces

    // Common concrete implementation
    public void displayCreditCardDetails() {
        System.out.println("CC Number: " + this.ccNumber + " , With Owner Name: " + this.ownerName);
    }
}