package Lesson3_AbstractClasses_And_Interfaces.InterfaceDemo;

/*
 * STEP 1: Define two interfaces - CanFly and CanSwim
 */

// Interface 1: Represents flying behavior
interface CanFly {
    void fly(); // abstract method to be implemented
}

// Interface 2: Represents swimming behavior
interface CanSwim {
    void swim(); // abstract method to be implemented
}

/*
 * STEP 2: Create a class Duck that implements both interfaces
 */

class Duck implements CanFly, CanSwim {

    // Implementing fly() from CanFly interface
    @Override
    public void fly() {
        System.out.println("Duck is flying in the sky 🦆✈️");
    }

    // Implementing swim() from CanSwim interface
    @Override
    public void swim() {
        System.out.println("Duck is swimming in the pond 🦆🌊");
    }
}

/*
 * STEP 3: Main class to test the functionality
 */

public class DuckInterfaceDemo {
    public static void main(String[] args) {

        // Creating a Duck object
        Duck duck = new Duck();

        // Direct method calls using Duck reference
        duck.fly();    // Output: Duck is flying in the sky 🦆✈️
        duck.swim();   // Output: Duck is swimming in the pond 🦆🌊

        // Interface-based polymorphic references
        CanFly flyer = new Duck();
        flyer.fly();   // Output: Duck is flying in the sky 🦆✈️

        CanSwim swimmer = new Duck();
        swimmer.swim(); // Output: Duck is swimming in the pond 🦆🌊
    }
}

