// File: Main.java
package Lesson4_LiskovSubstitutionPrinciple.Example1.BetterCode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // SOLUTION 1: Use specific interfaces for specific capabilities
        System.out.println("=== UPI Payment Processing ===");
        List<UpiCompatibleCreditCard> upiCards = new ArrayList<>();
        upiCards.add(new RuPayCard());
        
        // Clean code - no instanceof checks needed
        for(UpiCompatibleCreditCard card : upiCards) {
            card.upiPayment(); // Guaranteed to work - no exceptions
        }
        
        // SOLUTION 2: Use specific interfaces for international payments
        System.out.println("\n=== International Payment Processing ===");
        List<InternationalPaymentCompatibleCreditCard> intlCards = new ArrayList<>();
        intlCards.add(new VisaCard());
        intlCards.add(new MasterCard());
        
        // Clean code - no instanceof checks needed
        for(InternationalPaymentCompatibleCreditCard card : intlCards) {
            card.internationalPayment(); // Guaranteed to work - no exceptions
        }
        
        // SOLUTION 3: Still can use base CreditCard for common operations
        System.out.println("\n=== Common Credit Card Operations ===");
        List<CreditCard> allCards = new ArrayList<>();
        allCards.add(new VisaCard());
        allCards.add(new MasterCard());
        allCards.add(new RuPayCard());
        
        // All cards support these operations - perfect substitutability
        for(CreditCard card : allCards) {
            card.tapAndPay();
            card.onlineTransfer();
            card.swipeAndPay();
            card.mandatePayments();
            card.displayCreditCardDetails();
        }
    }
}

/*
BENEFITS OF THIS LSP-COMPLIANT APPROACH:

1. NO FORCED IMPLEMENTATION:
   - Cards only implement methods they actually support
   - No exceptions, no dummy implementations
   - Each class has only relevant behaviors

2. LSP COMPLIANCE:
   - Perfect substitutability within each interface
   - UpiCompatibleCreditCard subtypes are fully substitutable
   - InternationalPaymentCompatibleCreditCard subtypes are fully substitutable
   - CreditCard subtypes are fully substitutable for common operations

3. CLEAN ABSTRACTION:
   - Client code depends on appropriate interfaces
   - No instanceof checks needed
   - No knowledge of concrete implementations required

4. EASY MAINTENANCE:
   - Adding new card types doesn't break existing code
   - New capabilities can be added via new interfaces
   - Loose coupling between components

5. NO EXCEPTION HANDLING:
   - No runtime exceptions for unsupported operations
   - Compile-time safety through interfaces
   - Predictable behavior

6. BETTER TESTABILITY:
   - Each interface can be mocked easily
   - No special cases to test
   - Clean, focused unit tests

7. EXTENSIBILITY:
   - New cards can implement multiple interfaces (like AdvancedRuPayCard)
   - New payment methods can be added as new interfaces
   - Follows Open/Closed Principle
*/