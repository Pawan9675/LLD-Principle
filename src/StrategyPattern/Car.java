package StrategyPattern;

// ============================================================================
// WHAT IS THIS CLASS?
// ────────────────────
// Car is the PARENT / BASE CLASS for all car types (XUV700, XUV300, XUV400).
// It holds properties that are COMMON to ALL cars, regardless of engine type.
//
// WHY is this class separate?
// ────────────────────────────
// We follow the DRY principle — Don't Repeat Yourself.
// maxSpeed, hasAirBags, etc. exist in every car.
// Instead of writing them in XUV700, XUV300, XUV400 separately,
// we put them here ONCE, and all cars inherit them.
//
// WHAT should NOT be here?
// ─────────────────────────
// getPetrolData() and getBatteryData() should NOT be here.
//
// WHY? Because:
//   - Not every car is petrol → XUV400 would inherit getPetrolData() uselessly
//   - Not every car is electric → XUV700/XUV300 would inherit getBatteryData() uselessly
//   - This would FORCE every car to implement methods it doesn't need
//   - That violates the INTERFACE SEGREGATION PRINCIPLE (ISP):
//     "No class should be forced to implement methods it does not use"
//
// Instead, engine-specific behaviour is handled via:
//   1. Separate interfaces (PetrolEngine, BatteryEngine) — ISP applied
//   2. Strategy Pattern — engine logic injected from outside
// ============================================================================
public class Car {

    // Properties common to ALL cars — every car has a max speed and airbags.
    // 'private' = only accessible via getters/setters from outside this class.
    private int maxSpeed;       // Maximum speed of the car in km/h
    private boolean hasAirBags; // Does this car have airbags?
    // ... more common properties can be added here
    // (fuel capacity, number of seats, brand name, year of manufacture, etc.)
}


// ============================================================================