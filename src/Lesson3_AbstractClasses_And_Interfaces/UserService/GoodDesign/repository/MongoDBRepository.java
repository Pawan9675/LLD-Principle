package Lesson3_AbstractClasses_And_Interfaces.UserService.GoodDesign.repository;

// MongoDBRepository.java
public class MongoDBRepository implements IRepository {
    @Override
    public String getUser() {
        return "User from MongoDB";
    }

    @Override
    public String getUserByMail(String email) {
        return "User from MongoDB with email: " + email;
    }
}
