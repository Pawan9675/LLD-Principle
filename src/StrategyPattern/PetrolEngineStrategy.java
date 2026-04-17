package StrategyPattern;

// ============================================================================
// WHAT IS THIS CLASS?
// ────────────────────
// PetrolEngineStrategy is a CONCRETE STRATEGY — a specific, real implementation
// of the EngineStrategy interface for petrol engines.
//
// KEY POINT — Code lives here ONCE:
// ───────────────────────────────────
// Before Strategy Pattern, XUV700 and XUV300 BOTH had this identical logic:
//   public String getPetrolData() { return "Fuel: 30L, Temp: Normal"; }
//
// With Strategy Pattern, the logic lives HERE — in ONE place.
// XUV700 and XUV300 both DELEGATE to this class.
// If petrol data logic changes → update only THIS class → both cars fixed.
//
// OPEN/CLOSED PRINCIPLE (OCP) — SOLID:
// ──────────────────────────────────────
// The car classes (XUV700, XUV300) are CLOSED for modification.
// You can EXTEND the system by adding a new strategy (e.g. HybridEngineStrategy)
// WITHOUT touching any existing car class.
// ============================================================================
public class PetrolEngineStrategy implements EngineStrategy {

    // @Override — Retention = SOURCE → disappears after compilation.
    // Just a compiler hint that we're correctly implementing the interface method.

    @Override
    public String getEngineType() {
        // Returns the name/type of this engine.
        // Used when you want to know what kind of engine a car has.
        return "Petrol";
    }

    @Override
    public String getFuel() {
        // Returns petrol-specific fuel data.
        // In a real application, this would read from a sensor or database:
        //   - Current fuel level in litres
        //   - Engine temperature
        //   - Mileage, etc.
        // For our demo, it's a hardcoded String.
        return "30L";
    }
}


// ============================================================================