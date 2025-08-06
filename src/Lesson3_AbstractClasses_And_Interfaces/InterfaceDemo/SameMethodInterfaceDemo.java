package Lesson3_AbstractClasses_And_Interfaces.InterfaceDemo;

/*
 * Step 1: Define Interface A
 * Contains method display()
 */
interface A {
    void display();
}

/*
 * Step 1: Define Interface B
 * Also contains method display()
 */
interface B {
    void display();
}

/*
 * Step 2: Class C implements both interfaces A and B
 * A single method implementation handles both interface requirements
 */
class C implements A, B {

    // Single implementation for both A and B
    @Override
    public void display() {
        System.out.println("This display() satisfies both A and B interfaces.");
    }
}

/*
 * Step 3: Test class to demonstrate usage
 */
public class SameMethodInterfaceDemo {
    public static void main(String[] args) {

        System.out.println("---- Direct Object Call ----");
        C obj = new C();
        obj.display(); // Direct class call

        System.out.println("---- Polymorphic Calls Using Interfaces ----");
        A refA = new C(); // Reference of type A
        refA.display();   // Called through interface A

        B refB = new C(); // Reference of type B
        refB.display();   // Called through interface B
    }
}
