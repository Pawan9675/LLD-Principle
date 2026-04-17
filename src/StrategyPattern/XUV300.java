package StrategyPattern;

// ============================================================================
// SAME PATTERN AS XUV700 — explained here for completeness.
//
// XUV300 is also a petrol car. Before Strategy Pattern, XUV300 and XUV700
// had IDENTICAL getPetrolData() logic → code duplication → bug risk.
//
// With Strategy Pattern:
//   Both XUV300 and XUV700 delegate to this.engine.getFuel()
//   The actual petrol logic lives in PetrolEngineStrategy — ONCE.
//   Update PetrolEngineStrategy once → both XUV300 and XUV700 are updated.
//   No duplication. No risk of forgetting to update one class.
// ============================================================================
public class XUV300 extends Car implements PetrolEngine {

    // Holds the injected EngineStrategy — depends on interface, not concrete class.
    public EngineStrategy engine;

    // Constructor injection — strategy passed from outside (Main class).
    // Whoever creates an XUV300 decides which engine strategy it uses.
    public XUV300(EngineStrategy strategy) {
        this.engine = strategy;
    }

    // Implements PetrolEngine contract.
    // Delegates to the strategy — no petrol logic lives in this class itself.
    @Override
    public String getPetrolData() {
        return this.engine.getFuel();
        // XUV300 and XUV700 call the EXACT SAME LINE.
        // But they are NOT duplicating logic — the logic lives in PetrolEngineStrategy.
        // If "30L" needs to change to "45L", change PetrolEngineStrategy → done for both.
    }
}


// ============================================================================