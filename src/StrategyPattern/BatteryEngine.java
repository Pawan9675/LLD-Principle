package StrategyPattern;

// ============================================================================
// WHAT IS THIS INTERFACE?
// ────────────────────────
// BatteryEngine is a CONTRACT — any car that runs on a battery MUST implement
// this interface and provide a real body for getBatteryData().
//
// WHY a separate interface from PetrolEngine?
// ─────────────────────────────────────────────
// This is the Interface Segregation Principle (ISP) in action again.
// XUV700 and XUV300 (petrol cars) will NEVER implement BatteryEngine.
// XUV400 (electric) will NEVER implement PetrolEngine.
//
// Each interface is SMALL and FOCUSED on one specific type of engine.
// This avoids bloat and keeps responsibilities clean.
//
// Compare to the BAD approach where Car would have:
//   getPetrolData()  ← XUV400 would throw UnsupportedOperationException
//   getBatteryData() ← XUV700/XUV300 would throw UnsupportedOperationException
//
// That is messy. ISP via separate interfaces is the correct solution.
// ============================================================================
public interface BatteryEngine {

    // Any electric car that implements this interface MUST provide
    // a real implementation of getBatteryData().
    // Returns battery-specific info: charge %, range remaining, etc.
    public String getBatteryData();
}


// ============================================================================