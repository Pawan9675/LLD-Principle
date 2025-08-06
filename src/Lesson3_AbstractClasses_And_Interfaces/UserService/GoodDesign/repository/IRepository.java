package Lesson3_AbstractClasses_And_Interfaces.UserService.GoodDesign.repository;

// IRepository.java
public interface IRepository {
    String getUser();
    String getUserByMail(String email);
}
