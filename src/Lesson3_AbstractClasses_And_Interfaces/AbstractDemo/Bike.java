// Bike.java
package Lesson3_AbstractClasses_And_Interfaces.AbstractDemo;

public class Bike extends Vehicle {

    @Override
    public void start() {
        System.out.println("Bike starts with a kick or electric starter.");
    }

    @Override
    public void stop() {
        System.out.println("Bike stops using drum or disc brakes.");
    }
}
