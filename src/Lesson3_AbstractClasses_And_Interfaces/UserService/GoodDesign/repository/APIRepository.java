package Lesson3_AbstractClasses_And_Interfaces.UserService.GoodDesign.repository;

// APIRepository.java
public class APIRepository implements IRepository {
    @Override
    public String getUser() {
        return "User from external API";
    }

    @Override
    public String getUserByMail(String email) {
        return "User from API with email: " + email;
    }
}
