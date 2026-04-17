package StrategyPattern;

// ============================================================================
// WHAT IS DIFFERENT ABOUT XUV400?
// ─────────────────────────────────
// XUV400 is an ELECTRIC car. It:
//   1. Extends Car → inherits common car properties (maxSpeed, hasAirBags)
//   2. Implements BatteryEngine → declares itself as an electric car
//      (NOT PetrolEngine — that's the ISP applied correctly)
//   3. Uses EngineStrategy → same pattern as XUV700/XUV300
//
// KEY POINT:
//   XUV400 implements BatteryEngine and gets injected with BatteryEngineStrategy.
//   XUV700/XUV300 implement PetrolEngine and get injected with PetrolEngineStrategy.
//   But both use the SAME EngineStrategy interface → same pattern, same code structure.
//
// THE POWER OF STRATEGY PATTERN HERE:
// ─────────────────────────────────────
// Tomorrow if Mahindra adds an XUV450 (electric):
//   new XUV450(new BatteryEngineStrategy()) → done. No new strategy needed.
// Tomorrow if they add a HybridEngineStrategy:
//   Create HybridEngineStrategy → any car can receive it as strategy → zero car code changes.
//   This is the OPEN/CLOSED PRINCIPLE: open for extension, closed for modification.
// ============================================================================
public class XUV400 extends Car implements BatteryEngine {

    // Holds the injected EngineStrategy (BatteryEngineStrategy will be passed here).
    public EngineStrategy engine;

    // Constructor injection — BatteryEngineStrategy is passed from Main class.
    public XUV400(EngineStrategy strategy) {
        this.engine = strategy;
    }

    // Implements BatteryEngine contract — XUV400 is an electric car.
    // Delegates battery data to the injected strategy.
    @Override
    public String getBatteryData() {
        // BatteryEngineStrategy.getFuel() returns battery-specific info ("30%").
        // XUV400 just calls getFuel() — it doesn't know or care what's inside.
        // That's the beauty of the strategy — the car is decoupled from the logic.
        return this.engine.getFuel();
    }
}


// ============================================================================