// Main.java
package Lesson3_AbstractClasses_And_Interfaces.AbstractDemo;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.display();
        car.start();
        car.stop();

        System.out.println("----------------");

        Vehicle bike = new Bike();
        bike.display();
        bike.start();
        bike.stop();
    }
}
