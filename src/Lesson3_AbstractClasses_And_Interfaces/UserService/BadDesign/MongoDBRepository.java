package Lesson3_AbstractClasses_And_Interfaces.UserService.BadDesign;

// MongoDBRepository.java
public class MongoDBRepository {
    public String getUser() {
        return "User from MongoDB";
    }

    public String getUserByMail(String email) {
        return "User from MongoDB with email: " + email;
    }
}