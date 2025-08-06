package Lesson3_AbstractClasses_And_Interfaces.UserService.BadDesign;

// Main.java
public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.getUserData();
        service.getUserByEmail("test@example.com");
    }
}
