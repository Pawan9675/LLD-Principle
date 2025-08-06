// Vehicle.java
package Lesson3_AbstractClasses_And_Interfaces.AbstractDemo;

public abstract class Vehicle {

    // Abstract method — no body, must be implemented by subclass
    public abstract void start();

    public abstract void stop();

    // Concrete method — has a default implementation
    public void fuelType() {
        System.out.println("Most vehicles run on petrol or diesel.");
    }

    // Concrete method — common logic
    public void display() {
        System.out.println("Vehicle information:");
        fuelType(); // calling another method
    }
}
