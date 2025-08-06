package Lesson3_AbstractClasses_And_Interfaces.InterfaceDemo;

// Parent class 1
class Parent1 {
    void greet() {
        System.out.println("Hello from Parent1");
    }
}

// Parent class 2
class Parent2 {
    void greet() {
        System.out.println("Hello from Parent2");
    }
}

// ❌ Not Allowed: Java does NOT support multiple inheritance with classes
// class Child extends Parent1, Parent2 { // Compilation Error
//     void show() {
//         greet(); // Ambiguous: Which greet() to use?         --> Diamond Problem
//     }
// }

public class TestError {
    public static void main(String[] args) {
        System.out.println("Java does not support multiple class inheritance.");
    }
}
