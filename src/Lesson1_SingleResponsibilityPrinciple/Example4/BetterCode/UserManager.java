package Lesson1_SingleResponsibilityPrinciple.Example4.BetterCode;

public class UserManager {
    public String username;

    UserManager(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    // UserRepository userRepo;
    public void createUser(String username) {
        // Code to create a user
        // this.userRepo.create(...);
    }

    public void deleteUser(String username) {
        // Code to delete a user
        // this.userRepo.destroy(...);
    }
}