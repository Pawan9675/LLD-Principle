// File: Main.java
package Lesson4_LiskovSubstitutionPrinciple.Example1.ProblematicCode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CreditCard> cards = new ArrayList<>();
        
        // Add different types of cards
        cards.add(new VisaCard());
        cards.add(new MasterCard());
        cards.add(new RuPayCard());
        
        // PROBLEM 1: Trying to use UPI payment - requires specific type checking
        System.out.println("=== UPI Payment Attempt ===");
        for(CreditCard card : cards) {
            // BAD: We need instanceof checks - violates abstraction principle
            if(card instanceof RuPayCard) {
                card.upiPayment();
            } else {
                System.out.println("Card doesn't support UPI - " + card.getClass().getSimpleName());
            }
        }
        
        // PROBLEM 2: Trying international payment - similar issues
        System.out.println("\n=== International Payment Attempt ===");
        for(CreditCard card : cards) {
            // BAD: Again need specific type checking
            if(card instanceof VisaCard || card instanceof MasterCard) {
                card.intlPayment();
            } else {
                System.out.println("Card doesn't support international payments - " + card.getClass().getSimpleName());
            }
        }
        
        // PROBLEM 3: Loss of abstraction - client code knows about specific types
        // PROBLEM 4: Tight coupling - main class depends on concrete implementations
        // PROBLEM 5: Maintenance nightmare - adding new card types requires changes here
    }
}

/*
PROBLEMS WITH THIS APPROACH:

1. FORCED IMPLEMENTATION:
   - VisaCard and MasterCard forced to implement upiPayment() which they don't support
   - RuPayCard forced to implement intlPayment() which it doesn't support

2. LSP VIOLATION:
   - Cannot substitute CreditCard subclasses freely
   - Specific handling required for different card types
   - Program correctness depends on knowing concrete types

3. POOR ABSTRACTION:
   - Client code needs to know about specific card implementations
   - instanceof checks everywhere
   - Loss of polymorphism benefits

4. MAINTENANCE ISSUES:
   - Adding new card types requires changes in client code
   - Tight coupling between classes
   - Code becomes brittle and hard to extend

5. EXCEPTION HANDLING:
   - Either throw exceptions (runtime errors)
   - Or have empty/dummy implementations (misleading)
   - Both approaches are problematic

6. TESTING COMPLEXITY:
   - Need to test exception scenarios
   - Special cases for each card type
   - Complex conditional logic
*/