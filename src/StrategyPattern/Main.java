package StrategyPattern;

// ============================================================================
// WHAT DOES THIS CLASS DO?
// ─────────────────────────
// Main is the "client" or "assembler" — it creates strategy objects,
// creates car objects, INJECTS the strategies into the cars, and
// calls methods to see everything working together.
//
// This is where you can clearly see the Strategy Pattern in action:
//   - Different cars get different strategies
//   - Same car class (like Nexon) can get EITHER strategy
//   - No car class needs to change when you add a new strategy
// ============================================================================
public class Main {

    public static void main(String[] args) {

        // ── STEP 1: CREATE THE STRATEGIES ────────────────────────────────────
        // Create the strategy objects ONCE. They can be reused across multiple cars.
        // Type is the INTERFACE (EngineStrategy), not the concrete class.
        // This follows Dependency Inversion — depend on abstraction.
        EngineStrategy petrolStrategy  = new PetrolEngineStrategy();
        EngineStrategy batteryStrategy = new BatteryEngineStrategy();


        // ── STEP 2: INJECT STRATEGIES INTO CARS ──────────────────────────────

        // XUV700 is petrol → inject petrolStrategy
        // XUV700 constructor accepts EngineStrategy → Spring-like constructor injection
        XUV700 xuv700 = new XUV700(petrolStrategy);

        // XUV300 is also petrol → inject the SAME petrolStrategy object
        // Both XUV700 and XUV300 share the same strategy — no code duplication!
        XUV300 xuv300 = new XUV300(petrolStrategy);

        // XUV400 is electric → inject batteryStrategy
        XUV400 xuv400 = new XUV400(batteryStrategy);


        // ── STEP 3: CALL METHODS ──────────────────────────────────────────────
        System.out.println("=== Petrol Cars ===");

        // xuv700.getPetrolData() → calls this.engine.getFuel()
        //                        → PetrolEngineStrategy.getFuel() → "30L"
        System.out.println("XUV700 petrol data: " + xuv700.getPetrolData());

        // xuv300.getPetrolData() → calls this.engine.getFuel()
        //                        → PetrolEngineStrategy.getFuel() → "30L"
        // Same output as XUV700 because they share the same strategy!
        // But NO duplication — logic is in PetrolEngineStrategy, not both classes.
        System.out.println("XUV300 petrol data: " + xuv300.getPetrolData());

        System.out.println("\n=== Electric Car ===");

        // xuv400.getBatteryData() → calls this.engine.getFuel()
        //                         → BatteryEngineStrategy.getFuel() → "30%"
        System.out.println("XUV400 battery data: " + xuv400.getBatteryData());


        // ── STEP 4: THE NEXON DEMO — ONE CLASS, TWO ENGINE TYPES ─────────────
        // The REAL power of Strategy Pattern.
        // Nexon comes in both petrol and electric variants.
        // Without Strategy Pattern: Need NexonPetrol class AND NexonElectric class.
        // With Strategy Pattern: ONE Nexon class, inject different strategies.
        //
        // NOTE: For this demo we'll just use XUV700/XUV300 style approach.
        // Imagine a new car that accepts any strategy:

        System.out.println("\n=== Strategy Swap Demo ===");

        // Create a petrol XUV700
        XUV700 petrolCar = new XUV700(petrolStrategy);
        System.out.println("With petrol strategy: " + petrolCar.getPetrolData());
        // Output: With petrol strategy: 30L

        // Swap its strategy to battery at runtime — possible because field is public
        // (In production: use a setter method instead of public field)
        petrolCar.engine = batteryStrategy;
        System.out.println("After swapping to battery strategy: " + petrolCar.getPetrolData());
        // Output: After swapping to battery strategy: 30%
        // The XUV700 class didn't change at all — just the strategy was swapped!


        // ── STEP 5: ADDING A NEW ENGINE TYPE (OPEN/CLOSED DEMO) ──────────────
        // Suppose tomorrow we add HybridEngineStrategy.
        // We just create:
        //   public class HybridEngineStrategy implements EngineStrategy {
        //       public String getEngineType() { return "Hybrid"; }
        //       public String getFuel()       { return "15L petrol + 60% battery"; }
        //   }
        //
        // Then ANY car can use it:
        //   XUV700 hybridXUV = new XUV700(new HybridEngineStrategy());
        //
        // ZERO changes to XUV700, XUV300, XUV400, PetrolEngineStrategy,
        // BatteryEngineStrategy, or any other existing class.
        //
        // That is the OPEN/CLOSED PRINCIPLE:
        //   OPEN for extension  → add HybridEngineStrategy
        //   CLOSED for modification → don't touch existing classes

        System.out.println("\n=== Summary ===");
        System.out.println("Engine type for xuv700: " + xuv700.engine.getEngineType()); // Petrol
        System.out.println("Engine type for xuv400: " + xuv400.engine.getEngineType()); // Battery
    }
}

/*
 * ============================================================================
 * EXPECTED OUTPUT:
 * ============================================================================
 *
 * === Petrol Cars ===
 * XUV700 petrol data: 30L
 * XUV300 petrol data: 30L
 *
 * === Electric Car ===
 * XUV400 battery data: 30%
 *
 * === Strategy Swap Demo ===
 * With petrol strategy: 30L
 * After swapping to battery strategy: 30%
 *
 * === Summary ===
 * Engine type for xuv700: Petrol
 * Engine type for xuv400: Battery
 *
 * ============================================================================
 * COMPLETE PATTERN SUMMARY:
 * ============================================================================
 *
 * ROLES IN THE STRATEGY PATTERN:
 *   Strategy Interface  → EngineStrategy
 *   Concrete Strategies → PetrolEngineStrategy, BatteryEngineStrategy
 *   Context Classes     → XUV700, XUV300, XUV400 (they USE the strategy)
 *
 * SOLID PRINCIPLES APPLIED:
 *   ISP (Interface Segregation) → PetrolEngine and BatteryEngine are separate
 *   DIP (Dependency Inversion)  → Cars depend on EngineStrategy interface, not concrete class
 *   OCP (Open/Closed)           → Add new strategy without touching existing car classes
 *
 * DESIGN PRINCIPLES:
 *   Composition over Inheritance → Cars HAS-A EngineStrategy, not extends it
 *   Dependency Injection         → Strategy passed via constructor, not created inside
 *   Code Reuse                   → PetrolEngineStrategy shared by XUV700 and XUV300 — no duplication
 */