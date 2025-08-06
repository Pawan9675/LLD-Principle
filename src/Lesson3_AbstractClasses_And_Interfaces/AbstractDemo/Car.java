// Car.java
package Lesson3_AbstractClasses_And_Interfaces.AbstractDemo;

public class Car extends Vehicle {

    @Override
    public void start() {
        System.out.println("Car starts with a push button.");
    }

    @Override
    public void stop() {
        System.out.println("Car stops using disc brakes.");
    }
}
