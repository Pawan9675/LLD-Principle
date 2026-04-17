package StrategyPattern;

// ============================================================================
// WHAT IS THIS INTERFACE?
// ────────────────────────
// PetrolEngine is a CONTRACT — any car that is petrol-powered MUST implement
// this interface and provide a real body for getPetrolData().
//
// INTERFACE SEGREGATION PRINCIPLE (ISP) — SOLID:
// ─────────────────────────────────────────────────
// Instead of putting both getPetrolData() and getBatteryData() in the Car
// base class (which would force EVERY car to have both methods regardless
// of engine type), we SEPARATE them into two focused interfaces:
//
//   PetrolEngine  →  only for petrol cars  (XUV700, XUV300)
//   BatteryEngine →  only for electric cars (XUV400)
//
// This way:
//   XUV400 (electric) NEVER sees getPetrolData() — it doesn't implement this
//   XUV700 (petrol)   NEVER sees getBatteryData() — it doesn't implement that
//
// Clean, focused, no wasted methods.
// ============================================================================
public interface PetrolEngine {

    // Any petrol car that implements this interface MUST provide
    // a real implementation of getPetrolData().
    // Returns petrol-specific info: fuel level, engine temperature, etc.
    public String getPetrolData();
}


// ============================================================================