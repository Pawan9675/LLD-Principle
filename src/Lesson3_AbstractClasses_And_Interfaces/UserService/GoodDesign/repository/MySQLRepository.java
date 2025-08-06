package Lesson3_AbstractClasses_And_Interfaces.UserService.GoodDesign.repository;

// MySQLRepository.java
public class MySQLRepository implements IRepository {
    @Override
    public String getUser() {
        return "User from MySQL";
    }

    @Override
    public String getUserByMail(String email) {
        return "User from MySQL with email: " + email;
    }
}
