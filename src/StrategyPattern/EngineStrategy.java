package StrategyPattern;

// ============================================================================
// WHAT IS THIS INTERFACE?
// ────────────────────────
// EngineStrategy is the COMMON CONTRACT that ALL engine strategies must follow.
// Every engine — whether petrol, battery, or any future engine type — must
// implement getEngineType() and getFuel().
//
// THIS IS THE CORE OF THE STRATEGY PATTERN.
//
// WHY do we need this?
// ─────────────────────
// Problem without it:
//   XUV700 and XUV300 both had IDENTICAL getPetrolData() logic:
//     return "Fuel: 30L, Temp: Normal";
//   This is CODE DUPLICATION → if the logic changes, you must update EVERY
//   class. Miss one class = bug introduced. More cars = more duplication.
//
// Solution — Strategy Pattern:
//   Extract the behaviour (how to get engine data) into its own class.
//   That class is called a "STRATEGY".
//   The car class holds a REFERENCE to this strategy and DELEGATES to it.
//
// HOW IT WORKS:
// ─────────────
//   1. EngineStrategy (this interface)  → defines the contract
//   2. PetrolEngineStrategy             → implements for petrol
//   3. BatteryEngineStrategy            → implements for battery
//   4. XUV700, XUV300, XUV400          → hold a reference to EngineStrategy
//                                          and delegate engine work to it
//
// DEPENDENCY INVERSION PRINCIPLE (DIP) — SOLID:
// ───────────────────────────────────────────────
// The car classes depend on EngineStrategy (the INTERFACE / abstraction),
// NOT on PetrolEngineStrategy (the concrete class).
// This means you can swap strategies without touching the car classes at all.
//
// ANALOGY: Google Maps routing
//   The Maps app (car class) doesn't know HOW to calculate routes.
//   It just calls: strategy.getRoute()
//   You pass in: FastestRouteStrategy or ShortestRouteStrategy
//   Maps app doesn't change — only the strategy changes.
// ============================================================================
public interface EngineStrategy {

    // Returns the TYPE of engine as a String.
    // PetrolEngineStrategy → "Petrol"
    // BatteryEngineStrategy → "Battery"
    public String getEngineType();

    // Returns the CURRENT FUEL DATA as a String.
    // PetrolEngineStrategy → "Fuel: 30L, Temp: Normal"
    // BatteryEngineStrategy → "Battery: 75%, Range: 280km"
    public String getFuel();
}


// ============================================================================