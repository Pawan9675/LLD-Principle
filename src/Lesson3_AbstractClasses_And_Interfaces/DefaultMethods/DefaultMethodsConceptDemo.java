// Package declaration (optional based on your project structure)
package Lesson3_AbstractClasses_And_Interfaces.DefaultMethods;

/**
 * ✅ Part 1: What are Default Methods?
 * - Interfaces can have method implementations using 'default' keyword.
 * - Helps in extending interfaces without breaking existing implementations.
 */
interface Greeting {
    void sayHello(); // Abstract method (must be implemented)

    default void sayGoodbye() {
        System.out.println("Goodbye from Greeting Interface!");
    }

    default void sayGoodMorning() {
        System.out.println("Good Morning from Greeting Interface!");
    }
}

// ✅ Class implementing Greeting interface
class Person implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello from Person class!");
    }

    @Override
    public void sayGoodbye() {
        System.out.println("See you later from Person!");
    }
    // sayGoodMorning() is inherited as-is (no need to override)
}


/**
 * ✅ Part 2: Why Default Methods?
 * Problem: Adding new methods to interface breaks existing classes.
 * Solution: Add methods as default to preserve backward compatibility.
 */
interface Vehicle {
    void start();
    void stop();

    // Newly added method won't break older implementation
    default void honk() {
        System.out.println("Beep beep!");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
    // honk() is inherited automatically
}


/**
 * ✅ Part 3: Diamond Problem with Default Methods
 * - Occurs when two interfaces define the same default method.
 * - The class must resolve which one to use.
 */
interface A {
    default void display() {
        System.out.println("Display from A");
    }
}

interface B {
    default void display() {
        System.out.println("Display from B");
    }
}

// ❌ Class C must resolve conflict due to both interfaces defining display()
class C implements A, B {
    @Override
    public void display() {
        System.out.println("Resolving diamond problem in C:");
        A.super.display(); // Option 1: use A's version
        B.super.display(); // Option 2: also use B's version
        System.out.println("Custom display from C");
    }
}


/**
 * ✅ Part 4: Rule 1 - Class Wins Over Interface
 * - If class and interface both define the same method, class method wins.
 */
class Parent {
    public void method() {
        System.out.println("Method from Parent class");
    }
}

interface MyInterface {
    default void method() {
        System.out.println("Method from Interface");
    }
}

class Child extends Parent implements MyInterface {
    // No override needed. Parent class method overrides interface default.
}


/**
 * ✅ Part 5: Rule 2 - More Specific Interface Wins
 * - If interface B extends interface A and both have same method,
 *   B's method is used (because it's more specific).
 */
interface Animal {
    default void move() {
        System.out.println("Animal moves");
    }
}

interface Mammal extends Animal {
    @Override
    default void move() {
        System.out.println("Mammal walks");
    }
}

class Dog implements Mammal {
    // Inherits Mammal's move()
}


/**
 * ✅ Part 6: Rule 3 - Must Resolve Ambiguity Explicitly
 * - When two unrelated interfaces have same default method,
 *   implementing class must override and explicitly resolve it.
 */
interface X {
    default void test() {
        System.out.println("Test from Interface X");
    }
}

interface Y {
    default void test() {
        System.out.println("Test from Interface Y");
    }
}

class Z implements X, Y {
    @Override
    public void test() {
        System.out.println("Resolving conflict in Z:");
        X.super.test();  // or Y.super.test()
    }
}


/**
 * ✅ Main Class: Run all examples
 */
public class DefaultMethodsConceptDemo {
    public static void main(String[] args) {

        System.out.println("========== Part 1: Basic Default Methods ==========");
        Person person = new Person();
        person.sayHello();
        person.sayGoodbye();     // Overridden
        person.sayGoodMorning(); // Inherited as-is

        System.out.println("\n========== Part 2: Why Default Methods ==========");
        Car car = new Car();
        car.start();
        car.stop();
        car.honk();  // Inherited default method

        System.out.println("\n========== Part 3: Diamond Problem ==========");
        C objC = new C();
        objC.display();

        System.out.println("\n========== Part 4: Class Wins Over Interface ==========");
        Child child = new Child();
        child.method(); // Parent class method is called

        System.out.println("\n========== Part 5: More Specific Interface Wins ==========");
        Dog dog = new Dog();
        dog.move(); // Mammal's move()

        System.out.println("\n========== Part 6: Explicit Conflict Resolution ==========");
        Z z = new Z();
        z.test(); // X's version called explicitly
    }
}
