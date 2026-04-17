package StrategyPattern;

// ============================================================================
// WHAT IS THIS CLASS?
// ────────────────────
// BatteryEngineStrategy is the CONCRETE STRATEGY for electric/battery engines.
// It implements EngineStrategy with battery-specific logic.
//
// Before Strategy Pattern:
//   XUV400 had its own getBatteryData() logic directly inside its class.
//   If more electric cars were added (e.g., Nexon EV), they'd DUPLICATE it.
//
// With Strategy Pattern:
//   ALL electric cars share this ONE class.
//   Change battery logic once here → affects all electric cars automatically.
//
// INTERCHANGEABLE AT RUNTIME:
// ────────────────────────────
// You can even swap strategies at runtime if needed. For example:
//   car.engine = new BatteryEngineStrategy();  → now it behaves as electric
//   car.engine = new PetrolEngineStrategy();   → now it behaves as petrol
// This makes the system extremely flexible.
// ============================================================================
public class BatteryEngineStrategy implements EngineStrategy {

    @Override
    public String getEngineType() {
        // Returns the engine type for battery-powered cars.
        return "Battery";
    }

    @Override
    public String getFuel() {
        // Returns battery-specific data.
        // In a real application, this would read from the battery management system:
        //   - Current charge percentage
        //   - Estimated range on current charge
        //   - Charging status, battery health, etc.
        // For our demo, it's a hardcoded String.
        return "30%";
    }
}


// ============================================================================