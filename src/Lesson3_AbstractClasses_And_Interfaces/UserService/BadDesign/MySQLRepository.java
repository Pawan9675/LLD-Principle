package Lesson3_AbstractClasses_And_Interfaces.UserService.BadDesign;

// MySQLRepository.java
public class MySQLRepository {
    public String getUser() {
        return "User from MySQL";
    }

    public String getUserByMail(String email) {
        return "User from MySQL with email: " + email;
    }
}