package StrategyPattern;

// ============================================================================
// WHAT IS THIS CLASS?
// ────────────────────
// XUV700 is the CONTEXT in the Strategy Pattern. It:
//   1. Extends Car → inherits common car properties (maxSpeed, hasAirBags, etc.)
//   2. Implements PetrolEngine → declares itself as a petrol car
//   3. Uses EngineStrategy → delegates engine logic to the injected strategy
//
// "CONTEXT" in Strategy Pattern = the class that USES the strategy.
// It holds a reference to the strategy and calls it — that's all it does.
// It does NOT contain the engine logic itself.
//
// COMPOSITION OVER INHERITANCE:
// ──────────────────────────────
// XUV700 HAS-A EngineStrategy (composition).
// We didn't make XUV700 EXTEND PetrolEngineStrategy (inheritance).
// Why? Because composition is more flexible — we can change the strategy
// at runtime or have different cars share the same strategy object.
//
// DEPENDENCY INVERSION PRINCIPLE (DIP):
// ──────────────────────────────────────
// The field type is EngineStrategy (interface/abstraction),
// NOT PetrolEngineStrategy (concrete class).
// XUV700 doesn't care which concrete strategy it gets — it just
// calls getFuel() and the strategy handles the rest.
// ============================================================================
public class XUV700 extends Car implements PetrolEngine {

    // The strategy field — type is EngineStrategy (the INTERFACE, not concrete class).
    // 'public' here means it can be accessed/changed from outside the class.
    // In production code, this would typically be 'private' with a getter/setter
    // to control access properly. Public is kept here for simplicity.
    //
    // This is COMPOSITION — XUV700 HAS-A EngineStrategy object.
    // The engine strategy is what actually handles petrol-specific logic.
    public EngineStrategy engine;

    // CONSTRUCTOR INJECTION — the strategy is passed from outside.
    // XUV700 never does 'new PetrolEngineStrategy()' inside itself.
    // The caller (Main class) decides which strategy to plug in.
    //
    // This is DEPENDENCY INJECTION (DI):
    //   The dependency (engine strategy) is provided from outside,
    //   not created internally. This keeps XUV700 flexible and testable.
    //   In tests, you can pass a MockEngineStrategy to test XUV700 in isolation.
    public XUV700(EngineStrategy strategy) {
        this.engine = strategy;
    }

    // @Override — correctly implements the PetrolEngine interface contract.
    // PetrolEngine says: "you must have getPetrolData()". We do.
    @Override
    public String getPetrolData() {
        // DELEGATION — XUV700 doesn't compute the answer itself.
        // It asks the strategy: "what's the fuel data?"
        // The strategy (PetrolEngineStrategy) handles the actual logic.
        //
        // Before Strategy Pattern: return "Fuel: 30L, Temp: Normal"; ← hardcoded here
        // After Strategy Pattern:  delegate to engine.getFuel() ← logic in one place
        //
        // This means XUV700's getPetrolData() and XUV300's getPetrolData()
        // are NO LONGER duplicate code — they both delegate to the same strategy.
        return this.engine.getFuel();
    }
}


// ============================================================================